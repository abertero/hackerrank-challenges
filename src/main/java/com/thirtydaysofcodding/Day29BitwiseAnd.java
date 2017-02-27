package com.thirtydaysofcodding;

import java.util.Scanner;

public class Day29BitwiseAnd {

    public static void main(String[] args) {
        scannerOut();
    }

    private static void scannerOut() {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            int k = in.nextInt();
            System.out.println(findBitwiseAndLessThan(n, k));
        }
    }

    private static int findBitwiseAndLessThan(int n, int k) {
        int max = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                int bwa = bitwiseAnd(i, j);
                if (bwa > max && bwa < k) {
                    max = bwa;
                }
            }
        }
        return max;
    }

    public static int bitwiseAnd(int i, int j) {
        return i & j;
    }
}
