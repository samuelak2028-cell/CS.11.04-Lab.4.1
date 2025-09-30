import java.util.Scanner;

public class Main {

    // 1. parenthesesCheck
    public static boolean parenthesesCheck(String s) {
        int openCount = 0;
        int closeCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                openCount++;
            }
            if (s.charAt(i) == ')') {
                closeCount++;
            }
            if (closeCount > openCount) {
                return false;
            }
        }
        return (closeCount == openCount);
    }

    // 2. reverseInteger
    public static String reverseInteger(int n) {
        String myString = String.valueOf(n);
        String reverseString = "";
        for (int i = 1; i <= myString.length(); i++) {
            reverseString = reverseString + myString.charAt(myString.length() - i);
        }
        return reverseString;
    }

    //3.1 encrypting a single word
    public static String encryptWord(String input) {
        int lastChar = input.length() - 1;
        char firstLetter = input.charAt(0);
        int ascii = firstLetter;
        if (input.length()==1) {
            return String.valueOf(ascii);
        }
        if (input.length()==2) {
            return String.valueOf(ascii) + input.charAt(1);
        }
        if (input.length()==3) {
            return String.valueOf(ascii) + input.charAt(lastChar) + input.charAt(1);
        } else {
            return String.valueOf(ascii) + input.charAt(lastChar) + input.substring(2, lastChar) + input.charAt(1);
        }
    }

    // 3. encryptThis
    public static String encryptThis(String input) {
        String[] words = input.split(" ");
        String encrypted = "";
        for (int i = 0;i < words.length; i++) {
            encrypted += encryptWord(words[i]) + ' ';
        }
        return encrypted.substring(0, encrypted.length() - 1);
    }
    //4.1 decipherWord
    public static String decipherWord (String input) {
        String number = "";
        for (int i = 0;i<input.length();i++) {
            if (Character.isDigit(input.charAt(i))) {
                number += input.charAt(i);
            } else {
                break;
            }
        }
        String removedFirstLetter = input.substring(number.length());
        int lastChar = removedFirstLetter.length()-1;
        int ascii = Integer.parseInt (number);
        String firstLetterString = Character.toString((char)ascii);
        if (number.length() == input.length()) {
            return firstLetterString;
        }
        if (number.length() == input.length()-1) {
            return firstLetterString + removedFirstLetter.charAt(0);
        }
        if (number.length() == input.length()-2) {
            return firstLetterString + removedFirstLetter.charAt(lastChar) + removedFirstLetter.charAt(0);
        } else {
            return firstLetterString + removedFirstLetter.charAt(lastChar) + removedFirstLetter.substring(1,lastChar) + removedFirstLetter.charAt(0);
        }
    }
    // 4. decipherThis
    public static String decipherThis(String input) {
        String[] words = input.split(" ");
        String deciphered = "";
        for (int i = 0;i < words.length; i++) {
            deciphered += decipherWord(words[i]) + ' ';
        }
        return deciphered.substring(0, deciphered.length() - 1);
    }
}
