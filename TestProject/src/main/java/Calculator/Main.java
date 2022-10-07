package Calculator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws CalculatorException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение:");
        String s = scanner.nextLine();
        String result = calc(s);;
        System.out.println("Ответ: " + calc(s));
    }
    public static String calc (String input) throws CalculatorException{
        Converter converter = new Converter();
        String[] actions = {"+", "-", "/", "*"};
        String[] checkActions = {"\\+", "-", "/", "\\*"};
        int actionIndex = -1;
        for (int i = 0; i<actions.length; i++){
            if (input.contains(actions[i])){
                actionIndex = i;
                break;
            }
        }
        if (actionIndex == -1){
            throw new CalculatorException("Недопустимая операция!");
        }

        String[] data = input.split(checkActions[actionIndex]);

        for (int i = 0; i<actions.length; i++) {
            if (data[1].contains(actions[i])) {
                throw new CalculatorException("Введено больше 2 операндов и одного действия!");
            }
        }
        if (data.length > 2) {
            throw new CalculatorException("Введено больше 2 операндов и одного действия!");
        }

        if (converter.isTrue(data[0]) == converter.isTrue(data[1])) {
            int a, b, result = 0;
            String end = "";

            boolean tmp = converter.isTrue(data[0]);
            if (tmp){
                a = converter.romanToInt(data[0]);
                b = converter.romanToInt(data[1]);
            }
            else{
                a = Integer.parseInt(data[0]);
                b = Integer.parseInt(data[1]);
            }

            if ((a >= 10) || (a < 0) || (b >= 10) || (b < 0)) {
                throw new CalculatorException("Введеные числа выходят за пределы допустимого диапазона значений!");
            }
            switch (actions[actionIndex]){
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "/":
                    result = a/b;
                    break;
                case "*":
                    result = a*b;
                    break;
            }
            if (tmp) {
                if (result <= 0) {
                    throw new CalculatorException("В римской системе нет отрицательных чисел!");
                } else {
                    return (end = converter.intToRoman(result));
                }
            } else {
                return (end += result);
            }
        }
        else{
            throw new CalculatorException("Недопустимый формат числовых данных!");
        }
    }




}
