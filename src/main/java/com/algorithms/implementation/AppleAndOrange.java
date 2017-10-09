package com.algorithms.implementation;

import java.util.Scanner;

public class AppleAndOrange {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int t = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int m = in.nextInt();
        int n = in.nextInt();
        int[] apple = new int[m];
        for (int apple_i = 0; apple_i < m; apple_i++) {
            apple[apple_i] = in.nextInt();
        }

        int[] orange = new int[n];
        for (int orange_i = 0; orange_i < n; orange_i++) {
            orange[orange_i] = in.nextInt();
        }
        int apples = getFruitsInHome(s, t, a, m, apple);
        System.out.println(apples);
        int oranges = getFruitsInHome(s, t, b, n, orange);
        System.out.println(oranges);
    }

    private static int getFruitsInHome(int s, int t, int b, int n, int[] distances) {
        int counter = 0;
        for (int i = 0; i < n; i++) {
            int dist = distances[i];
            if (b + dist <= t && b + dist >= s) {
                ++counter;
            }
        }
        return counter;
    }
}
