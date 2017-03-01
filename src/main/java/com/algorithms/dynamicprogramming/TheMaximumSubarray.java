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
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = scn.nextInt();
            }
            Map.Entry<Integer, Integer> result = getMaximumSubarray(arr, n);
            System.out.println(String.format("%s %s", result.getKey(), result.getValue()));
        }
        scn.close();
    }

    private static Map.Entry<Integer, Integer> getMaximumSubarray(final int[] arr, final int n) {
        int discont = Integer.MIN_VALUE;
        int sumOfEverything = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0 || arr[i] > discont) {
                discont += arr[i];
            }
            sumOfEverything += arr[i];
        }
        int i = 0;
        int j = n - 1;
        int contMax = sumOfEverything;
        int sumOfI = 0;
        int sumOfJ = 0;
        while (i < j) {
            if (contMax - arr[i] > contMax) {
                contMax = contMax - arr[i];
                ++i;
            }
            if (i < j && contMax - arr[j] > contMax) {
                contMax = contMax - arr[j];
                --j;
            }
        }

        return new AbstractMap.SimpleEntry<>(0, discont);
    }
}
