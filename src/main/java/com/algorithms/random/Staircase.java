package com.algorithms.random;

import java.util.Scanner;

/**
 * Created by thesc on 31-01-2017.
 */
public class Staircase {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int i = 1; i <= n; ++i) {
            System.out.println(String.format("%s%s", multiplyChar(n - i, " "), multiplyChar(i, "#")));
        }
    }

    private static String multiplyChar(int numberOfTimes, String character) {
        return new String(new char[numberOfTimes]).replace("\0", character);
    }
}
