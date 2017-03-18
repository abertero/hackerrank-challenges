package com.algorithms.sorting;

import java.util.Scanner;

public class RunningTimeOfAlgorithms {

    public static void insertionSortTime(int[] a) {
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
        System.out.println(cycles);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = in.nextInt();
        }
        insertionSortTime(ar);
    }
}
