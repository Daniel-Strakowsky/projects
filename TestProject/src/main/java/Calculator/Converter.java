package Calculator;

import java.util.TreeMap;

public class Converter {
    TreeMap<Character, Integer> keyMap = new TreeMap<>();
    TreeMap<Integer, String> romanMap = new TreeMap<>();

    public Converter(){
        keyMap.put('I', 1);
        keyMap.put('V', 5);
        keyMap.put('X', 10);
        keyMap.put ('L', 50);
        keyMap.put ('C', 100);

        romanMap.put(100, "C");
        romanMap.put(50, "L");
        romanMap.put(10, "X");
        romanMap.put(9, "IX");
        romanMap.put(5, "V");
        romanMap.put(4, "IV");
        romanMap.put(1, "I");
    }

    public int romanToInt(String s){
        int end = s.length()-1;
        char[] arr = s.toCharArray();
        int arabian;
        int result = keyMap.get(arr[end]);
        for (int i = end-1; i >= 0; i--){
            arabian = keyMap.get(arr[i]);
            if (arabian < keyMap.get(arr[i+1])){
                result -= arabian;
            } else {
                result += arabian;
            }
        }
        return result;
    }

    public String intToRoman(int s) {
        String roman = "";
        int key;
        do {
            key = romanMap.floorKey(s);
            roman += romanMap.get(key);
            s -= key;
        } while (s != 0);
        return roman;
    }



    public boolean isTrue(String number){
        return keyMap.containsKey(number.charAt(0));
    }
}
