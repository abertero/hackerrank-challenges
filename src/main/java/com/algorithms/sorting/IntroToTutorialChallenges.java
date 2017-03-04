package com.algorithms.sorting;

import java.util.Scanner;

public class IntroToTutorialChallenges {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        int n = scn.nextInt();
        for (int i = 0; i < n; i++) {
            int a = scn.nextInt();
            if (a == t) {
                System.out.println(i);
            }
        }
        scn.close();
    }
}
