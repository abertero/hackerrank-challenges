package com.mathematics;

import java.util.Scanner;

public class Handshake {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scn.nextInt();
            System.out.println(handshakes(n));
        }
        scn.close();
    }

    private static int handshakes(int n) {
        return n * (n - 1) / 2;
    }
}
