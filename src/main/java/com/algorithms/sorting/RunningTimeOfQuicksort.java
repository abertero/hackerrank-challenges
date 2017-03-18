package com.algorithms.sorting;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Scanner;

public class RunningTimeOfQuicksort {

    public static int quicksort(int[] ar, int lo, int hi) {
        int swaps = 0;
        if (lo < hi) {
            Map.Entry<Integer, Integer> pair = partition(ar, lo, hi);
            swaps += pair.getKey();
            int p = pair.getValue();
            swaps += quicksort(ar, lo, p - 1);
            swaps += quicksort(ar, p + 1, hi);
        }
        return swaps;
    }

    private static Map.Entry<Integer, Integer> partition(int[] ar, int lo, int hi) {
        int swaps = 0;
        int pivot = ar[hi];
        int i = lo - 1;
        for (int j = lo; j < hi; j++) {
            if (ar[j] <= pivot) {
                ++i;
                int aux = ar[i];
                ar[i] = ar[j];
                ar[j] = aux;
                ++swaps;
            }
        }
        int aux = ar[i + 1];
        ar[i + 1] = ar[hi];
        ar[hi] = aux;
        ++swaps;
        return new AbstractMap.SimpleEntry<>(swaps, i + 1);
    }

    public static int insertionSortTime(int[] a) {
        int cycles = 0;
        for (int i = 1; i < a.length; i++) {
            int value = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > value) {
                ++cycles;
                a[j + 1] = a[j];
                j = j - 1;
            }
            a[j + 1] = value;
        }
        return cycles;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        int[] arr = new int[t];
        int[] arr2 = new int[t];
        for (int i = 0; i < t; i++) {
            arr[i] = scn.nextInt();
            arr2[i] = arr[i];
        }
        int quicksortSwaps = quicksort(arr, 0, t - 1);
        int insertionShifts = insertionSortTime(arr2);
        System.out.println(insertionShifts - quicksortSwaps);
        scn.close();
    }
}
