package com.mathematics;

import java.util.Scanner;

public class SherlockAndMovingTiles {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        long l = scn.nextLong();
        long s1 = scn.nextLong();
        long s2 = scn.nextLong();
        long t = scn.nextLong();
        for (int i = 0; i < t; i++) {
            long q = scn.nextLong();
            double time = findTimeWhenAreaInTiles(l, s1, s2, q);
            System.out.println(time);
        }
        scn.close();
    }

    private static double findTimeWhenAreaInTiles(long l, long s1, long s2, long q) {
        if (q > Math.pow(l, 2)) {
            return -1;
        } else if (q == Math.pow(l, 2)) {
            return 0;
        }
        double d = Math.sqrt(2 * q);
        // v1 = d1/t, v2 = d2/t
        // |d1-d2| = d ==> |v1*t-v2*t| = d ==> t*|v1-v2| = d
        // t = d/|v1-v2|
        return (Math.sqrt(2) * l - d) / Math.abs(s1 - s2);
    }
}
