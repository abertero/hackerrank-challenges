package com.mathematics;

import java.math.BigInteger;
import java.util.Scanner;

public class ConnectingTowns {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int q = scn.nextInt();
        for (int i = 0; i < q; i++) {
            int t = scn.nextInt();
            long[] n = new long[t - 1];
            for (int j = 0; j < t - 1; j++) {
                n[j] = scn.nextLong();
            }
            BigInteger total = numberOfRoutes(n);
            System.out.println(total.mod(BigInteger.valueOf(1234567)));
        }
        scn.close();
    }

    private static BigInteger numberOfRoutes(long[] n) {
        BigInteger total = BigInteger.ONE;
        for (int i = 0; i < n.length; i++) {
            total = total.multiply(BigInteger.valueOf(n[i]));
        }
        return total;
    }
}
