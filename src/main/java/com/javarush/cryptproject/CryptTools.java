package com.javarush.cryptproject;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

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
            System.out.println(key + ":" + value);
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
}
