package com.thirtydaysofcodding;

import java.util.Scanner;

public class Day02Operators {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double mealCost = scan.nextDouble(); // original meal price
        int tipPercent = scan.nextInt(); // tip percentage
        int taxPercent = scan.nextInt(); // tax percentage
        scan.close();

        // Write your calculation code here.
        double realMealCost = mealCost * (1.0 + taxPercent/100.0 + tipPercent/100.0);

        // cast the result of the rounding operation to an int and save it as totalCost
        int totalCost = (int) Math.round(realMealCost);

        // Print your result
        System.out.println(String.format("The total meal cost is %s dollars.", totalCost));
    }
}
