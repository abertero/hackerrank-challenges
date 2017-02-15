package com.thirtydaysofcodding;

import java.util.Scanner;

public class Day09Recursion {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(factorial(n));
    }

    private static int factorial(int n) {
        if (n < 1) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}
