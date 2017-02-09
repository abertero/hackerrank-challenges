package com.algorithms.implementation;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MinMaxSum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long a = in.nextLong();
        long b = in.nextLong();
        long c = in.nextLong();
        long d = in.nextLong();
        long e = in.nextLong();
        in.close();
        long[] arr = minMaxSum(new long[]{a, b, c, d, e});
        System.out.println(String.format("%s %s", arr[0], arr[1]));
    }

    private static long[] minMaxSum(long[] arr) {
        long sum = 0;
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        for (int i = 0; i < arr.length; ++i) {
            sum += arr[i];
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return new long[]{sum - max, sum - min};
    }

}
