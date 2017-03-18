package com.algorithms.sorting;

import java.util.Scanner;

public class InsertionSortPart1 {

    public static void insertIntoSorted(int[] ar) {
        int aux;
        for (int i = 0; i < ar.length - 1; i++) {
            if (ar[i] > ar[i + 1]) {
                aux = ar[i + 1];
                int j = i;
                while (j >= 0 && aux < ar[j]) {
                    ar[j + 1] = ar[j];
                    --j;
                    printArray(ar);
                }
                ar[j + 1] = aux;
                printArray(ar);
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        for (int i = 0; i < s; i++) {
            ar[i] = in.nextInt();
        }
        insertIntoSorted(ar);
    }


    private static void printArray(int[] ar) {
        for (int n : ar) {
            System.out.print(n + " ");
        }
        System.out.println("");
    }
}
