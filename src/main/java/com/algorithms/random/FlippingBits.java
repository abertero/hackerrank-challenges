package com.algorithms.random;

import java.util.Scanner;

/**
 * You will be given a list of 32 bits unsigned integers. You are required to output the list of the unsigned integers you get by flipping bits in its binary representation (i.e. unset bits must be set, and set bits must be unset).
 * <p/>
 * Input Format
 * <p/>
 * The first line of the input contains the list size , which is followed by  lines, each line having an integer from the list.
 * <p/>
 * Constraints
 * <p/>
 * <p/>
 * <p/>
 * Output Format
 * <p/>
 * Output one line per element from the list with the requested result.
 * <p/>
 * Sample Input
 * <p/>
 * 3
 * 2147483647
 * 1
 * 0
 * Sample Output
 * <p/>
 * 2147483648
 * 4294967294
 * 4294967295
 * Explanation
 * <p/>
 * Take 1 for example, as unsigned 32-bits is 00000000000000000000000000000001 and doing the flipping we get 11111111111111111111111111111110 which in turn is 4294967294.
 */
public class FlippingBits {
    public static void main(String[] args) {
        scannerMain();
    }

    private static void scannerMain() {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            long n = in.nextLong();
            System.out.println(flipBits(n));
        }
    }

    private static long flipBits(long i) {
        String bitRep = leftPad(Long.toString(i, 2), 32, "0");
        String invRep = invert(bitRep);
        return Long.parseLong(invRep, 2);
    }

    private static String invert(String binRepresentation) {
        String aux = "";
        for (int i = 0; i < binRepresentation.length(); i++) {
            char c = binRepresentation.charAt(i);
            if (c == '0') {
                aux += "1";
            } else {
                aux += "0";
            }
        }
        return aux;
    }

    private static String leftPad(String str, int length, String padString) {
        String aux = str;
        for (int i = 0; i < length - str.length(); i++) {
            aux = padString + aux;
        }
        return aux;
    }
}
