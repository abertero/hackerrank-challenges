package com.thirtydaysofcodding;

import java.util.Scanner;

public class Day05Loops {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 1; i <= 10; i++) {
            System.out.println(String.format("%s x %s = %s", n, i, n * i));
        }
    }
}
