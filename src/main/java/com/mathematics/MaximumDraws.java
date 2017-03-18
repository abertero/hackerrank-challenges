package com.mathematics;

import java.util.Scanner;

public class MaximumDraws {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scn.nextInt();
            System.out.println(maximumDraws(n));
        }
        scn.close();
    }

    private static int maximumDraws(int n) {
        return n + 1;
    }
}
