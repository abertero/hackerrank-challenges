package com.algorithms;

import java.util.Scanner;

public class PlusMinus {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for (int arr_i = 0; arr_i < n; arr_i++) {
            arr[arr_i] = in.nextInt();
        }
        double[] rates = calculatePositiveNegativeAndZerosPercentage(arr, n);
        System.out.println(rates[0]);
        System.out.println(rates[1]);
        System.out.println(rates[2]);
    }

    private static double[] calculatePositiveNegativeAndZerosPercentage(int[] arr, int n) {
        double[] resuls = new double[3];
        int positiveCount = 0, negativeCount = 0, zeroCount = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                ++positiveCount;
            } else if (arr[i] < 0) {
                ++negativeCount;
            } else {
                ++zeroCount;
            }
        }
        resuls[0] = (double) positiveCount / n;
        resuls[1] = (double) negativeCount / n;
        resuls[2] = (double) zeroCount / n;
        return resuls;
    }
}
