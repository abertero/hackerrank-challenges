package com.algorithms.implementation;

import java.util.Scanner;

public class BreakingTheRecords {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] s = new int[n];
        for (int s_i = 0; s_i < n; s_i++) {
            s[s_i] = in.nextInt();
        }
        int[] result = getRecord(s);
        String separator = "", delimiter = " ";
        for (Integer val : result) {
            System.out.print(separator + val);
            separator = delimiter;
        }
        System.out.println("");
    }

    private static int[] getRecord(int[] s) {
        int[] result = new int[2];
        int maxScore = s[0];
        int minScore = s[0];
        for (int i = 1; i < s.length; i++) {
            if (maxScore < s[i]) {
                maxScore = s[i];
                ++result[0];
            }
            if (minScore > s[i]) {
                minScore = s[i];
                ++result[1];
            }
        }
        return result;
    }
}
