package com.thirtydaysofcodding;

import java.util.Scanner;

public class Day10BinaryNumbers {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(maxNumberOf1InBase2Integer(n));
    }

    private static int maxNumberOf1InBase2Integer(int n) {
        int max = 0;
        int curr = 0;
        boolean isCurr = false;
        String binaryRepresentation = Integer.toString(n, 2);
        for (int i = 0; i < binaryRepresentation.length(); i++) {
            int currVal = Integer.parseInt(String.valueOf(binaryRepresentation.charAt(i)));
            if (currVal == 1) {
                if (isCurr) {
                    ++curr;
                } else {
                    isCurr = true;
                    ++curr;
                }
            } else {
                if (isCurr) {
                    isCurr = false;
                    if (curr > max) {
                        max = curr;
                    }
                    curr = 0;
                }
            }
        }
        if (curr > max) {
            max = curr;
        }
        return max;
    }


}
