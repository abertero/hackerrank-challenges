package com.algorithms.strings;

import java.util.Scanner;

public class BeautifulBinaryString {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.nextLine();
        String str = scn.nextLine();
        System.out.println(beautifulBinaryString(str));
        scn.close();
    }

    private static int beautifulBinaryString(String str) {
        if (!str.contains("010")) {
            return 0;
        }
        return 1 + beautifulBinaryString(str.replaceFirst("010", "011"));
    }
}
