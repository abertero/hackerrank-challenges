package com.algorithms.random;

import java.util.Scanner;

public class BirthdayCakeCandles {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for (int ar_i = 0; ar_i < n; ar_i++) {
            ar[ar_i] = in.nextInt();
        }
        int result = birthdayCakeCandles(n, ar);
        System.out.println(result);
    }

    private static int birthdayCakeCandles(int n, int[] ar) {
        int tallestCandleHeight = 0;
        int numberOfCandles = 0;
        for (int i = 0; i < n; i++) {
            int currentCandle = ar[i];
            if (tallestCandleHeight < currentCandle) {
                tallestCandleHeight = currentCandle;
                numberOfCandles = 1;
            } else if (tallestCandleHeight == currentCandle) {
                ++numberOfCandles;
            }
        }
        return numberOfCandles;
    }
}
