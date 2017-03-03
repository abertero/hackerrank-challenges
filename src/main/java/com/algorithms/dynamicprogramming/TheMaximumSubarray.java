package com.algorithms.dynamicprogramming;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Scanner;

public class TheMaximumSubarray {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scn.nextInt();
            long[] arr = new long[n];
            for (int j = 0; j < n; j++) {
                arr[j] = scn.nextLong();
            }
            Map.Entry<Long, Long> result = getMaximumSubarray(arr, n);
            System.out.println(String.format("%s %s", result.getKey(), result.getValue()));
        }
        scn.close();
    }

    private static Map.Entry<Long, Long> getMaximumSubarray(long[] arr, int n) {
        long discont = Integer.MIN_VALUE;
        long maxCont = Long.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (arr[i] < 0 && arr[i] > discont) {
                discont = arr[i];
            } else if (arr[i] > 0) {
                if (discont < 0) {
                    discont = 0;
                }
                discont += arr[i];
            }
            for (int j = i; j < n; j++) {
                long auxSum = 0;
                for (int k = i; k <= j; k++) {
                    auxSum += arr[k];
                }
                if (auxSum > maxCont) {
                    maxCont = auxSum;
                }
            }
        }

        return new AbstractMap.SimpleEntry<>(maxCont, discont);
    }
}
