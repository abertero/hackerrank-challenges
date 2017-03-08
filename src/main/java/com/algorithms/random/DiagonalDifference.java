package com.algorithms.random;

import java.util.Scanner;

/**
 * Created by thesc on 29-01-2017.
 */
public class DiagonalDifference {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[][] = new int[n][n];
        for (int a_i = 0; a_i < n; a_i++) {
            for (int a_j = 0; a_j < n; a_j++) {
                a[a_i][a_j] = in.nextInt();
            }
        }
        System.out.println(diagonalDifference(a, n));
    }

    public static int diagonalDifference(int[][] a, int n) {
        int firstDiagonal = 0;
        int secondDiagonal = 0;
        for (int i = 0; i < n; i++) {
            firstDiagonal += a[i][i];
            secondDiagonal += a[n - 1 - i][i];
        }
        return Math.abs(firstDiagonal - secondDiagonal);
    }
}
