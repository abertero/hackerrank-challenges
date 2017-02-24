package com.thirtydaysofcodding;

import java.util.Scanner;

public class Day25RunningTimeAndComplexity {
    public static void main(String[] args) {
        System.out.println(determineIfPrime(1));
        System.out.println(determineIfPrime(4));
        System.out.println(determineIfPrime(9));
        System.out.println(determineIfPrime(16));
        System.out.println(determineIfPrime(25));
        System.out.println(determineIfPrime(36));
        System.out.println(determineIfPrime(49));
        System.out.println(determineIfPrime(64));
        System.out.println(determineIfPrime(81));
        System.out.println(determineIfPrime(100));
        System.out.println(determineIfPrime(121));
        System.out.println(determineIfPrime(144));
        System.out.println(determineIfPrime(169));
        System.out.println(determineIfPrime(196));
        System.out.println(determineIfPrime(225));
        System.out.println(determineIfPrime(256));
        System.out.println(determineIfPrime(289));
        System.out.println(determineIfPrime(324));
        System.out.println(determineIfPrime(361));
        System.out.println(determineIfPrime(400));
        System.out.println(determineIfPrime(441));
        System.out.println(determineIfPrime(484));
        System.out.println(determineIfPrime(529));
        System.out.println(determineIfPrime(576));
        System.out.println(determineIfPrime(625));
        System.out.println(determineIfPrime(676));
        System.out.println(determineIfPrime(729));
        System.out.println(determineIfPrime(784));
        System.out.println(determineIfPrime(841));
        System.out.println(determineIfPrime(907));
        //scannerOut();
    }

    private static void scannerOut() {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        for (int i = 0; i < n; i++) {
            int number = scn.nextInt();
            System.out.println(determineIfPrime(number));
        }
    }

    public static String determineIfPrime(int number) {
        if (number == 1) {
            return "Not prime";
        }
        int sqrt = (int) Math.sqrt(number);
        for (int i = 2; i <= sqrt; i++) {
            if (number % i == 0) {
                return "Not prime";
            }
        }
        return "Prime";
    }
}
