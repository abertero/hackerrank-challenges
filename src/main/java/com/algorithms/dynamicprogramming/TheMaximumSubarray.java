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
        int contI = 0;
        int contJ = 0;
        long maxCont = Integer.MIN_VALUE;
        long newPossibleCont = -1;
        int newPosI = -1;
        int newPosJ = -1;

        for (int i = 0; i < n; i++) {
            if (arr[i] < 0 && arr[i] > discont) {
                discont = arr[i];
                maxCont = arr[i];
                contI = 0;
                contJ = 0;
            } else if (arr[i] > 0) {
                if (discont < 0) {
                    discont = 0;
                }
                if (maxCont < 0) {
                    maxCont = arr[i];
                    contI = 0;
                    contJ = 0;
                } else if (contJ == i - 1) {
                    maxCont += arr[i];
                    contJ = i;
                } else if (newPosJ == i - 1) {
                    newPossibleCont += arr[i];
                    newPosJ = i;
                    if (newPossibleCont > maxCont) {
                        maxCont = newPossibleCont;
                        contI = newPosI;
                        contJ = newPosJ;
                    }
                } else {
                    newPossibleCont = arr[i];
                    newPosI = i;
                    newPosJ = i;
                    if (newPossibleCont > maxCont) {
                        maxCont = newPossibleCont;
                        contI = newPosI;
                        contJ = newPosJ;
                    }
                }
                discont += arr[i];
            }
        }

        return new AbstractMap.SimpleEntry<>(getSum(arr, contI, contJ), discont);
    }

    private static long getSum(long[] arr, int i, int j) {
        long result = 0;
        for (int k = i; k <= j; k++) {
            result += arr[k];
        }
        return result;
    }
}
