package Calculator;

import java.util.Scanner;

public class Calc {

    public static void main(String[] args) throws CalculatorException {

        Converter converter = new Converter();
        String[] actions = {"+", "-", "/", "*"};
        String[] checkActions = {"\\+", "-", "/", "\\*"};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение:");

        String string = scanner.nextLine();
        int actionIndex = -1;
        for (int i = 0; i<actions.length; i++){
            if (string.contains(actions[i])){
                actionIndex = i;

                break;
            }
        }
        if (actionIndex == -1){
            throw new CalculatorException("Недопустимая операция!");
        }

        String[] data = string.split(checkActions[actionIndex]);

        if (converter.isTrue(data[0]) == converter.isTrue(data[1])) {
            int a, b, result = 0;

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
                    System.out.println("Ответ: " + converter.intToRoman(result));
                }
            } else {
                System.out.print("Ответ: " + result);
            }
        }
        else{
            throw new CalculatorException("Недопустимый формат числовых данных!");
        }
    }
}
