package com.algorithms.sorting;

import java.util.Scanner;

public class QuicksortInPlace {

    public static void quicksort(int[] ar, int lo, int hi) {
        if (lo < hi) {
            int p = partition(ar, lo, hi);
            quicksort(ar, lo, p - 1);
            quicksort(ar, p + 1, hi);
        }
    }

    private static int partition(int[] ar, int lo, int hi) {
        int pivot = ar[hi];
        int i = lo - 1;
        for (int j = lo; j < hi; j++) {
            if (ar[j] <= pivot) {
                ++i;
                int aux = ar[i];
                ar[i] = ar[j];
                ar[j] = aux;
            }
        }
        int aux = ar[i + 1];
        ar[i + 1] = ar[hi];
        ar[hi] = aux;
        printArray(ar);
        return i + 1;
    }

    static void printArray(int[] ar) {
        for (int n : ar) {
            System.out.print(n + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = scn.nextInt();
        }
        scn.close();
        quicksort(ar, 0, ar.length - 1);
    }
}
