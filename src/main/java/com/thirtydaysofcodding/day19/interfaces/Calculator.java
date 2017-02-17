package com.thirtydaysofcodding.day19.interfaces;

public class Calculator implements AdvancedArithmetic {
    @Override
    public int divisorSum(int n) {
        if (n == 1) {
            return 1;
        }
        int divisorSum = 1 + n;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                divisorSum += i;
            }
        }
        return divisorSum;
    }
}
