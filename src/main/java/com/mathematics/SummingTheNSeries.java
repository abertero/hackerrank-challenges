package com.mathematics;

import java.math.BigInteger;
import java.util.Scanner;

public class SummingTheNSeries {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        for (int i = 0; i < t; i++) {
            long n = scn.nextLong();
            BigInteger sumOfN = sumOfSeriesN(n);
            long mod = (long) (Math.pow(10, 9) + 7);
            System.out.println(sumOfN.mod(BigInteger.valueOf(mod)));
        }
        scn.close();
    }

    private static BigInteger sumOfSeriesN(long n) {
        return BigInteger.valueOf(n).pow(2);
    }
}
