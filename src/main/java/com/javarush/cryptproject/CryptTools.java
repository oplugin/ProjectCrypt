package com.javarush.cryptproject;

import java.util.*;

public class CryptTools {

    public String encryptString(String string, int offset) {
        String returnString = "";
        for (int i = 0; i < string.length(); i++) {
            returnString += encryptChar(string.charAt(i), offset);
        }
        return returnString;
    }

    public static char encryptChar(char encryptChar, int offset) {
        if (Character.isUpperCase(encryptChar)) {
            return (char) ((int) encryptChar + offset);
        } else if (Character.isLowerCase(encryptChar)) {
            return (char) ((int) encryptChar + offset);
        } else {
            return (char) ((int) encryptChar + offset);
        }
    }

    public String decryptString(String string, int offset) {
        String returnString = "";
        for (int i = 0; i < string.length(); i++) {
            returnString += decryptChar(string.charAt(i), offset);
        }
        return returnString;
    }

    public static char decryptChar(char encryptChar, int offset) {
        if (Character.isUpperCase(encryptChar)) {
            return (char) ((int) encryptChar - offset);
        } else if (Character.isLowerCase(encryptChar)) {
            return (char) ((int) encryptChar - offset);
        } else {
            return (char) ((int) encryptChar - offset);
        }
    }

    public int checkPartOfText(String text) {
        int stringStart = text.length() / 10;
        int stringEnd = stringStart + 100;
        String substringText = text.substring(stringStart, stringEnd);
        char encChar = ' ';
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < substringText.length(); i++) {
            if (!Character.isLetter(substringText.charAt(i)) && !Character.isDigit(substringText.charAt(i))) {
                map.put(substringText.charAt(i), i);
                encChar = substringText.charAt(i);
            }
        }
        TreeMap<Character, Integer> sortedMap = new TreeMap<>();
        sortedMap.putAll(map);
        for (Map.Entry<Character, Integer> pair : sortedMap.entrySet()) {
            Character key = pair.getKey();                      //ключ
            Integer value = pair.getValue();                  //значение
            System.out.println("Potential key : " + key + ":" + value);
        }
        int key = 0;
        Character firstKey = sortedMap.firstKey();
        for (int i = 0; i <= 10; i++) {
            if (decryptChar(firstKey, i) == ' ') {
                System.out.println("Key is " + i);
                key = i;
                break;
            }
        }
        return key;
    }

    public int analyseText(String textEnc, String textAnalise) {
        HashMap<Character, Integer> encryptedText = getCharacterStatistic(textEnc);
        HashMap<Character, Integer> statisticText = getCharacterStatistic(textAnalise);
        TreeMap<Character, Integer> sortedMapEncText = new TreeMap<>();
        sortedMapEncText.putAll(encryptedText);
//        for (Map.Entry<Character, Integer> pair : sortedMapEncText.entrySet()) {
//            Character key = pair.getKey();                      //ключ
//            Integer value = pair.getValue();                  //значение
//            System.out.println(key + ":" + value);
//        }
//
//        System.out.println("-------------");
        TreeMap<Character, Integer> sortedMapStatisticText = new TreeMap<>();
        sortedMapStatisticText.putAll(statisticText);
//        for (Map.Entry<Character, Integer> pair : sortedMapStatisticText.entrySet()) {
//            Character key = pair.getKey();                      //ключ
//            Integer value = pair.getValue();                  //значение
//            System.out.println(key + ":" + value);
//        }
//
//        System.out.println("-------------");
        Character firstKeyEncText = sortedMapEncText.firstKey();
        Character firstKeyStatText = sortedMapStatisticText.firstKey();
//        System.out.println("firstKeyEncText : " + firstKeyEncText);
//        System.out.println("firstKeyStatText : " + firstKeyStatText);
        int keyEncText = firstKeyEncText;
        int keyStatText = firstKeyStatText;
        int key = keyEncText - keyStatText;
        System.out.println("Main key potentially is : " + key);
        return key;
    }

    public HashMap<Character, Integer> getCharacterStatistic(String text) {
        HashMap<Character, Integer> textMap = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            Integer integer = textMap.get(c);
            if (integer == null) {
                textMap.put(c, 1);
            } else {
                integer++;
                textMap.put(c, integer);
            }
        }
        for (Character character : textMap.keySet()) {
            Integer integer = textMap.get(character);
            int i = integer * 10_000 / text.length();
            textMap.put(character, i);
        }
        sortMap(textMap);
        return textMap;
    }

    public static LinkedHashMap<Character, Integer> sortMap(HashMap<Character, Integer> map) {
        LinkedHashMap<Character, Integer> result = new LinkedHashMap<>();
        int[] values = new int[map.values().size()];
        Collection<Integer> values1 = map.values();
        int i = 0;
        for (Integer integer : values1) {
            values[i] = integer;
            i++;
        }
        for (int j = 0; i < values.length; j++) {
            for (int k = 0; k < values.length - 1; k++) {
                if (values[k] < values[k + 1]) {
                    int temp = values[k];
                    values[k] = values[k + 1];
                    values[k + 1] = temp;
                }
            }
        }
        for (int j = 0; j < values.length; j++) {
            for (Character character : map.keySet()) {
                if (values[j] == map.get(character)) {
                    result.put(character, values[j]);
                    break;
                }
            }
        }
        return result;
    }
}
