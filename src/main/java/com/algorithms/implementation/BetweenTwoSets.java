package com.algorithms.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BetweenTwoSets {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }
        int[] b = new int[m];
        for (int b_i = 0; b_i < m; b_i++) {
            b[b_i] = in.nextInt();
        }
        int total = getTotalX(a, b);
        System.out.println(total);
        in.close();
    }

    private static int getTotalX(int[] a, int[] b) {
        int maxA = 0;
        int minB = Integer.MAX_VALUE;
        for (int ai : a) {
            if (maxA < ai) {
                maxA = ai;
            }
        }
        for (int bi : b) {
            if (minB > bi) {
                minB = bi;
            }
        }
        List<Integer> numbersBetweenTwoSets = new ArrayList<>();
        for (int i = maxA; i <= minB; i++) {
            if (isFactorOfSet(b, i)) {
                numbersBetweenTwoSets.add(i);
            }
        }
        Integer[] factorsOfB = numbersBetweenTwoSets.toArray(new Integer[numbersBetweenTwoSets.size()]);
        for (int i = 0; i < factorsOfB.length; i++) {
            if (!setIsFactorOfElement(a, factorsOfB[i])) {
                numbersBetweenTwoSets.remove(factorsOfB[i]);
            }
        }
        return numbersBetweenTwoSets.size();
    }

    private static boolean setIsFactorOfElement(int[] a, int x) {
        for (int ai : a) {
            if (x % ai != 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isFactorOfSet(int[] b, int x) {
        for (int bi : b) {
            if (bi % x != 0) {
                return false;
            }
        }
        return true;
    }
}
