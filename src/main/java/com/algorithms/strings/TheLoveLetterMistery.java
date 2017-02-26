package com.algorithms.strings;

import java.util.Scanner;

public class TheLoveLetterMistery {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        scn.nextLine();
        for (int i = 0; i < t; i++) {
            String str = scn.nextLine();
            System.out.println(getStepsUntilPalindrome(str));
        }
        scn.close();
    }

    private static int getStepsUntilPalindrome(String str) {
        int count = 0;
        int middleLength = str.length() / 2;
        for (int i = 0; i < middleLength; i++) {
            count += getAsciiAbs(str.charAt(i), str.charAt(str.length() - 1 - i));
        }
        return count;
    }

    private static int getAsciiAbs(char c, char c1) {
        return Math.abs(((int) c) - ((int) c1));
    }
}
