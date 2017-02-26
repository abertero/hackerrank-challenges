package com.algorithms.strings;

import java.util.Scanner;

public class AlternatingCharacters {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        scn.nextLine();
        for (int i = 0; i < t; i++) {
            String str = scn.nextLine();
            System.out.println(numberOfDeletions(str));
        }
        scn.close();
    }

    private static int numberOfDeletions(String str) {
        int n = 0;
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                ++n;
            }
        }
        return n;
    }
}
