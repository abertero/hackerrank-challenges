package com.thirtydaysofcodding;

import java.util.Scanner;

public class Day16Exceptions {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String S = in.next();
        System.out.println(stringToInteger(S));
    }

    private static String stringToInteger(String s) {
        try {
            int parsedString = Integer.parseInt(s);
            return "" + parsedString;
        } catch (NumberFormatException e) {
            return "Bad String";
        }
    }
}
