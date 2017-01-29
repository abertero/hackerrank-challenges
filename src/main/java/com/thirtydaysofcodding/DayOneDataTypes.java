package com.thirtydaysofcodding;

import java.util.Scanner;

/**
 * Created by aldo on 29-01-17.
 */
public class DayOneDataTypes {

    public static void main(String[] args) {
        int i = 4;
        double d = 4.0;
        String s = "HackerRank ";

        Scanner scan = new Scanner(System.in);

        int first = Integer.parseInt(scan.nextLine());
        double second = Double.parseDouble(scan.nextLine());
        String third = scan.nextLine();

        System.out.println(first + i);
        System.out.println(second + d);
        System.out.println(s + third);

        scan.close();
    }
}
