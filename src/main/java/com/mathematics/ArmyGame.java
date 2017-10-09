package com.mathematics;

import java.util.Scanner;

public class ArmyGame {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int supplies = minimumSupplies(n, m);
        System.out.println(supplies);
    }

    private static int minimumSupplies(int n, int m) {
        if (n % 2 == 0 && m % 2 == 0) {
            return n * m / 4;
        } else if (n % 2 == 0) {
            return minimumSupplies(n, m - 1) + n / 2;
        } else if (m % 2 == 0) {
            return minimumSupplies(n - 1, m) + m / 2;
        } else {
            return minimumSupplies(n - 1, m - 1) + (n - 1) / 2 + (m - 1) / 2 + 1;
        }
    }
}
