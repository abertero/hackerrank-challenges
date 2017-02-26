package com.algorithms.strings;

import java.util.Scanner;

public class PalindromeIndex {

    public static void main(String[] args) {
        scannerOut();
    }

    private static void scannerOut() {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        scn.nextLine();
        for (int i = 0; i < t; i++) {
            String str = scn.nextLine();
            System.out.println(palindromeIndex(str));
        }
        scn.close();
    }

    private static int palindromeIndex(String str) {
        int palIdx = doPalindromeIndex(str);
        int revPalIdx = doPalindromeIndex(reverse(str));
        return Math.max(palIdx, revPalIdx == -1 ? revPalIdx : str.length() - 1 - revPalIdx);
    }

    private static int doPalindromeIndex(String str) {
        int middleLength = str.length() / 2;
        boolean removed = false;
        int startIdx = 0;
        int endIdx = str.length() - 1;
        int possible = -1;
        for (int i = 0; i < middleLength; i++) {
            if (str.charAt(startIdx) != str.charAt(endIdx)) {
                if (removed) {
                    return -1;
                } else if (str.charAt(startIdx) == str.charAt(endIdx - 1)) {
                    removed = true;
                    possible = endIdx;
                    --endIdx;
                } else if (str.charAt(startIdx + 1) == str.charAt(endIdx)) {
                    removed = true;
                    possible = startIdx;
                    ++startIdx;
                } else {
                    return -1;
                }
            }
            ++startIdx;
            --endIdx;
        }
        return possible;
    }

    public static String reverse(String element) {
        if (element == null) {
            return null;
        }
        return new StringBuffer(element).reverse().toString();
    }
}
