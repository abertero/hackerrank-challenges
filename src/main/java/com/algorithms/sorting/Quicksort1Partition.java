package com.algorithms.sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quicksort1Partition {

    static void partition(int[] ar) {
        List<Integer> left = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        int p = ar[0];

        for (int i : ar) {
            if (i > p) {
                right.add(i);
            } else if (i < p) {
                left.add(i);
            } else {
                equal.add(i);
            }
        }

        left.addAll(equal);
        left.addAll(right);
        printArray(left.toArray(new Integer[ar.length]));
    }

    static void printArray(Integer[] ar) {
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
        partition(ar);
    }
}
