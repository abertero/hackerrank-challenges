package com.algorithms;

import java.util.Scanner;

public class CompareTheTriplets {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a0 = in.nextInt();
        int a1 = in.nextInt();
        int a2 = in.nextInt();
        int b0 = in.nextInt();
        int b1 = in.nextInt();
        int b2 = in.nextInt();

        int[] results = compareTriplets(a0, a1, a2, b0, b1, b2);
        System.out.println(results[0] + " " + results[1]);
    }

    public static int[] compareTriplets(int a0, int a1, int a2, int b0, int b1, int b2) {
        int[] results = new int[2];
        results[0] = 0;
        results[1] = 0;
        if (a0 > b0) {
            ++results[0];
        } else if (a0 < b0) {
            ++results[1];
        }

        if (a1 > b1) {
            ++results[0];
        } else if (a1 < b1) {
            ++results[1];
        }

        if (a2 > b2) {
            ++results[0];
        } else if (a2 < b2) {
            ++results[1];
        }

        return results;
    }
}
