package com.thirtydaysofcodding;

import java.util.Scanner;

public class Day06LetsReview {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        for (int i = 1; i <= n; i++) {
            String line = in.nextLine();
            String evens = "";
            String odds = "";
            for (int j = 0; j < line.length(); j++) {
                if (j % 2 == 0) {
                    evens += line.charAt(j);
                } else {
                    odds += line.charAt(j);
                }
            }
            System.out.println(String.format("%s %s", evens, odds));
        }
    }
}
