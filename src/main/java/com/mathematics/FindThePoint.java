package com.mathematics;

import java.util.Scanner;

public class FindThePoint {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        for (int i = 0; i < n; i++) {
            int px = scn.nextInt();
            int py = scn.nextInt();
            int qx = scn.nextInt();
            int qy = scn.nextInt();

            int[] r = pointReflection(px, py, qx, qy);
            System.out.println(String.format("%s %s", r[0], r[1]));
        }
        scn.close();
    }

    private static int[] pointReflection(int px, int py, int qx, int qy) {
        int rx = 2 * qx - px;
        int ry = 2 * qy - py;
        return new int[]{rx, ry};
    }
}
