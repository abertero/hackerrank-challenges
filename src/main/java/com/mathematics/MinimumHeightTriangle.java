package com.mathematics;

import java.util.Scanner;

public class MinimumHeightTriangle {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int b = scn.nextInt();
        int a = scn.nextInt();
        scn.close();
        int h = lowestTriangle(b, a);
        System.out.println(h);
    }

    private static int lowestTriangle(int base, int area) {
        return (int) Math.ceil(2 * area / (double) base);
    }
}
