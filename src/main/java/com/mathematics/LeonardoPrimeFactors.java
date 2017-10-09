package com.mathematics;

import java.math.BigInteger;
import java.util.Scanner;

public class LeonardoPrimeFactors {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int q = scn.nextInt();
        for (int i = 0; i < q; i++) {
            long n = scn.nextLong();
            int p = findPrimeFactors(n);
            System.out.println(p);
        }
        scn.close();
    }

    private static int findPrimeFactors(long n) {
        BigInteger factor = BigInteger.ONE;
        int factorCount = 0;
        for (long i = 2; i <= n; i++) {
            if (isPrime(i)) {
                factor = factor.multiply(BigInteger.valueOf(i));
                if (factor.subtract(BigInteger.valueOf(n)).compareTo(BigInteger.ZERO) > 0) {
                    break;
                } else {
                    ++factorCount;
                }
            }
        }
        return factorCount;
    }

    private static boolean isPrime(long n) {
        if (n < 2) {
            return false;
        } else if (n < 4) {
            return true;
        }
        long square = (long) Math.sqrt(n);
        for (int i = 2; i <= square; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
