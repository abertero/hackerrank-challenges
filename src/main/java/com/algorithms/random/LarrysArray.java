package com.algorithms.random;

import java.util.Scanner;

/**
 * TODO: Incomplete
 */
public class LarrysArray {
    public static void main(String[] args) {
        int[] a1 = new int[]{3, 1, 2};
        int[] a2 = new int[]{1, 3, 4, 2};
        int[] a3 = new int[]{1, 2, 3, 5, 4};
        int[] a4 = new int[]{5, 3, 2};
        System.out.println(yesNo(canSort(a1)));
        System.out.println(yesNo(canSort(a2)));
        System.out.println(yesNo(canSort(a3)));
        System.out.println(yesNo(canSort(a4)));

        //scannerReader();
    }

    public static void scannerReader() {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        String[] results = new String[t];
        for (int i = 0; i < t; ++i) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = scanner.nextInt();
            }
            results[i] = yesNo(canSort(arr));
        }
        scanner.close();
        for (int i = 0; i < t; i++) {
            System.out.println(results[i]);
        }
    }

    public static String yesNo(boolean trueFalse) {
        return trueFalse ? "YES" : "NO";
    }

    private static boolean canSort(int[] array) {
        if (array == null || array.length == 1) {
            return true;
        } else if (array.length == 2) {
            return array[0] < array[1];
        } else {
            int i = 0;
            while (i + 2 < array.length) {
                if (canSortTrio(array[i], array[i + 1], array[i + 2])) {
                    int[] sortedTrio = sortTrio(array[i], array[i + 1], array[i + 2]);
                    array[i] = sortedTrio[0];
                    array[i + 1] = sortedTrio[1];
                    array[i + 2] = sortedTrio[2];
                } else {
                    return false;
                }
                ++i;
            }
            return true;
        }
    }

    private static boolean canSortTrio(int first, int second, int third) {
        if (first < second && second < third) {
            return true;
        } else if (second < third && third < first) {
            return true;
        } else if (third < first && first < second) {
            return true;
        }
        return false;
    }

    private static int[] sortTrio(int first, int second, int third) {
        if (first < second && second < third) {
            return new int[]{first, second, third};
        } else if (second < third && third < first) {
            return new int[]{second, third, first};
        } else {
            return new int[]{third, first, second};
        }
    }
}
