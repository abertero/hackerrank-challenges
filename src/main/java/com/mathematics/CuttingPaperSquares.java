package com.mathematics;

import java.math.BigInteger;
import java.util.Scanner;

public class CuttingPaperSquares {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        BigInteger result = solve(n, m);
        System.out.println(result);
    }

    private static BigInteger solve(int n, int m) {
        if (n == 1) {
            return BigInteger.valueOf(m - 1);
        } else if (m == 1) {
            return BigInteger.valueOf(n - 1);
        }
        return BigInteger.valueOf(n).multiply(BigInteger.valueOf(m)).subtract(BigInteger.ONE);
    }
}
