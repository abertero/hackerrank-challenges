package com.thirtydaysofcodding;

import java.util.Scanner;

public class Day112DArrays {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        System.out.println(getMaxHourglassSum(arr));
    }

    private static int getMaxHourglassSum(int[][] arr) {
        int maxHourglass = Integer.MIN_VALUE;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int hourglass = getHourglassSum(arr, i, j);
                if (hourglass > maxHourglass) {
                    maxHourglass = hourglass;
                }
            }
        }
        return maxHourglass;
    }

    private static int getHourglassSum(int[][] arr, int i, int j) {
        return arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + 1] + arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];
    }
}
