package com.mathematics;

import java.util.Scanner;

public class LeonardsPrimeFactors {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        for (int i = 0; i < t; i++) {
            double n = scn.nextDouble();
            System.out.println(leonardPrimeFactors(n));
        }
        scn.close();
    }

    private static int leonardPrimeFactors(double n) {
        double sq = Math.sqrt(n);
        int numberOfMult = 0;
        int mult = 1;
        for (double i = 1; i <= sq; i++) {
            if (isPrime(i)) {
                mult *= i;
                if (mult <= n) {
                    ++numberOfMult;
                } else {
                    return numberOfMult;
                }
            }
        }
        return numberOfMult;
    }

    private static boolean isPrime(double n) {
        if (n <= 1) {
            return false;
        }
        if (n > 1 && n <= 5 && n != 4) {
            return true;
        } else if (n % 2 == 0) {
            return false; // nos permite descartar los pares.
        } else {
            int sqrt = (int) Math.sqrt(n);
            for (int i = 3; i <= sqrt; i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
