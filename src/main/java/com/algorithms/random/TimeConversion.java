package com.algorithms.random;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TimeConversion {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String time = in.next();
        System.out.println(convertDate(time));
    }

    public static String convertDate(String oldFormatDate) {
        SimpleDateFormat oldSdf = new SimpleDateFormat("h:mm:ssa");
        Date date = null;
        try {
            date = oldSdf.parse(oldFormatDate);
        } catch (ParseException e) {
        }
        SimpleDateFormat newSdf = new SimpleDateFormat("HH:mm:ss");
        return newSdf.format(date);
    }
}
