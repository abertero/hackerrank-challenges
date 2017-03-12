package com.algorithms.sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quicksort2Sorting {

    static void quickSort(int[] ar) {
        List<Integer> originalArray = new ArrayList<>();
        for (int i : ar) {
            originalArray.add(i);
        }
        List<Integer> elements = doQuickSort(originalArray);
        printList(elements);
    }

    private static List<Integer> doQuickSort(List<Integer> ar) {
        int p = ar.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int i = 1; i < ar.size(); i++) {
            int val = ar.get(i);
            if (val > p) {
                right.add(val);
            } else {
                left.add(val);
            }
        }
        if (left.size() > 1) {
            left = doQuickSort(left);
            printList(left);
        }
        if (right.size() > 1) {
            right = doQuickSort(right);
            printList(right);
        }
        left.add(p);
        left.addAll(right);
        return left;
    }

    static void printList(List<Integer> ar) {
        for (Integer n : ar) {
            System.out.print(n + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = in.nextInt();
        }
        quickSort(ar);
    }
}
