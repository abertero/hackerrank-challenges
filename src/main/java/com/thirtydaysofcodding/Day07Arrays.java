package com.thirtydaysofcodding;

import java.util.Scanner;

public class Day07Arrays {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        in.close();
        String result = "";
        if (n > 0) {
            result += arr[n - 1];
        }
        if (n > 1) {
            for (int i = n - 2; i >= 0; --i) {
                result += " " + arr[i];
            }
        }
        System.out.println(result);
    }
}
