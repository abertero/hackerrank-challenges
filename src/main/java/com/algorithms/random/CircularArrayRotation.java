package com.algorithms.random;

import java.util.Scanner;

public class CircularArrayRotation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int q = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; ++i) {
            a[i] = in.nextInt();
        }
        int[] m = new int[q];
        for (int i = 0; i < q; ++i) {
            m[i] = in.nextInt();
        }
        int[] rotateA = rotateArray(a, k);

        for (int i = 0; i < q; i++) {
            System.out.println(rotateA[(m[i] % n)]);
        }
        in.close();
    }

    public static int[] rotateArray(int[] a, int k) {
        int[] result = new int[a.length];
        for (int i = 0; i < a.length; ++i) {
            result[(i + k) % a.length] = a[i];
        }
        return result;
    }
}
