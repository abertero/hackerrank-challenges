package com.thirtydaysofcodding;

import java.util.Scanner;

public class Day20Sorting {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }
        int numberOfSwaps = bubbleSort(a, n);
        System.out.println(String.format("Array is sorted in %s swaps.", numberOfSwaps));
        System.out.println(String.format("First Element: %s", a[0]));
        System.out.println(String.format("Last Element: %s", a[n - 1]));
    }

    public static int bubbleSort(int[] a, int n) {
        int totalNumberOfSwaps = 0;
        for (int i = 0; i < n; i++) {
            // Track number of elements swapped during a single array traversal
            int numberOfSwaps = 0;

            for (int j = 0; j < n - 1; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                    numberOfSwaps++;
                }
            }

            // If no elements were swapped during a traversal, array is sorted
            if (numberOfSwaps == 0) {
                break;
            } else {
                totalNumberOfSwaps += numberOfSwaps;
            }
        }
        return totalNumberOfSwaps;
    }

    private static void swap(int[] a, int i, int j) {
        int aux = a[i];
        a[i] = a[j];
        a[j] = aux;
    }
}
