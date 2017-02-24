package com.thirtydaysofcodding;

import java.util.Scanner;

public class Day26NestedLogic {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int actuallyDay = scn.nextInt();
        int actuallyMonth = scn.nextInt();
        int actuallyYear = scn.nextInt();
        int expectedDay = scn.nextInt();
        int expectedMonth = scn.nextInt();
        int expectedYear = scn.nextInt();
        System.out.println(calculateHackos(actuallyDay, actuallyMonth, actuallyYear, expectedDay, expectedMonth, expectedYear));
        scn.close();
    }

    public static int calculateHackos(final int actuallyDay, final int actuallyMonth, final int actuallyYear, final int expectedDay, final int expectedMonth, final int expectedYear) {
        if (expectedYear > actuallyYear) {
            return 0;
        } else if (expectedYear == actuallyYear) {
            if (expectedMonth > actuallyMonth) {
                return 0;
            } else if (expectedMonth == actuallyMonth) {
                return Math.max(15 * (actuallyDay - expectedDay), 0);
            } else {
                return 500 * (actuallyMonth - expectedMonth);
            }
        } else {
            return 10000;
        }
    }
}
