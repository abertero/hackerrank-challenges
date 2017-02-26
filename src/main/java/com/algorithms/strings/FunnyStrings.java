package com.algorithms.strings;

import java.util.Scanner;

/**
 * Suppose you have a String, , of length  that is indexed from  to . You also have some String, , that is the reverse of String .  is funny if the condition  is true for every character from  to .
 * <p/>
 * Note: For some String ,  denotes the ASCII value of the  -indexed character in . The absolute value of an integer, , is written as .
 * <p/>
 * Input Format
 * <p/>
 * The first line contains an integer,  (the number of test cases).
 * Each line  of the  subsequent lines contain a string, .
 * <p/>
 * Constraints
 * <p/>
 * Output Format
 * <p/>
 * For each String  (where ), print whether it is  or  on a new line.
 * <p/>
 * Sample Input
 * <p/>
 * 2
 * acxz
 * bcxz
 * Sample Output
 * <p/>
 * Funny
 * Not Funny
 * Explanation
 * <p/>
 * Test Case 0:
 * <p/>
 * <p/>
 * <p/>
 * As each comparison is equal, we print .
 * <p/>
 * Test Case 1:
 * , but
 * At this point, we stop evaluating  (as ) and print Not Funny.
 */
public class FunnyStrings {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        scn.nextLine();
        for (int i = 0; i < t; i++) {
            String str = scn.nextLine();
            System.out.println(funny(str));
        }
        scn.close();
    }

    private static String funny(String str) {
        return isFunny(str) ? "Funny" : "Not Funny";
    }

    private static boolean isFunny(String str) {
        String revStr = reverse(str);
        for (int i = 1; i < str.length(); i++) {
            if (getAsciiAbs(str.charAt(i), str.charAt(i - 1)) != getAsciiAbs(revStr.charAt(i), revStr.charAt(i - 1))) {
                return false;
            }
        }
        return true;
    }

    private static int getAsciiAbs(char c, char c1) {
        return Math.abs(((int) c) - ((int) c1));
    }

    public static String reverse(String element) {
        if (element == null) {
            return null;
        }
        return new StringBuffer(element).reverse().toString();
    }
}
