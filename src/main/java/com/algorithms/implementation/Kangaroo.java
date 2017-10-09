package com.algorithms.implementation;

import java.util.Scanner;

public class Kangaroo {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x1 = in.nextInt();
        int v1 = in.nextInt();
        int x2 = in.nextInt();
        int v2 = in.nextInt();
        String result = kangaroo(x1, v1, x2, v2);
        System.out.println(result);
    }

    private static String kangaroo(int x1, int v1, int x2, int v2) {
        double s = -(x1 - x2) / (double) (v1 - v2);
        if (s < Double.POSITIVE_INFINITY && (Math.ceil(s) == s || Math.floor(s) == s)) {
            return s >= 0 ? "YES" : "NO";
        }
        return "NO";
    }
}
