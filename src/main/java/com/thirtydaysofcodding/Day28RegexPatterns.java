package com.thirtydaysofcodding;

import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day28RegexPatterns {

    public static void main(String[] args) {
        System.out.println(isGmail("riya@gmail.com"));
        System.out.println(isGmail("julia@julia.me"));
        System.out.println(isGmail("sjulia@gmail.com"));
        System.out.println(isGmail("julia@gmail.com"));
        System.out.println(isGmail("samantha@gmail.com"));
        System.out.println(isGmail("tanya@gmail.com"));
        System.out.println(isGmail("ariya@gmail.com"));
        System.out.println(isGmail("bjulia@julia.me"));
        System.out.println(isGmail("csjulia@gmail.com"));
        System.out.println(isGmail("djulia@gmail.com"));
        System.out.println(isGmail("esamantha@gmail.com"));
        System.out.println(isGmail("ftanya@gmail.com"));
        System.out.println(isGmail("riya@live.com"));
        System.out.println(isGmail("julia@live.com"));
        System.out.println(isGmail("sjulia@live.com"));
        System.out.println(isGmail("julia@live.com"));
        System.out.println(isGmail("samantha@live.com"));
        System.out.println(isGmail("tanya@live.com"));
        System.out.println(isGmail("ariya@live.com"));
        System.out.println(isGmail("bjulia@live.com"));
        System.out.println(isGmail("csjulia@live.com"));
        System.out.println(isGmail("djulia@live.com"));
        System.out.println(isGmail("esamantha@live.com"));
        System.out.println(isGmail("ftanya@live.com"));
        System.out.println(isGmail("gmail@riya.com"));
        System.out.println(isGmail("priya@gmail.com"));
        System.out.println(isGmail("preeti@gmail.com"));
        System.out.println(isGmail("alice@alicegmail.com"));
        System.out.println(isGmail("alice@gmail.com"));
        System.out.println(isGmail("gmail.alice@gmail.com"));
        //scannerOut();
    }

    private static void scannerOut() {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        List<String> names = new ArrayList<>();
        for (int a0 = 0; a0 < N; a0++) {
            String firstName = in.next();
            String emailID = in.next();
            if (isGmail(emailID)) {
                names.add(firstName);
            }
        }
        Collections.sort(names);
        for (String name : names) {
            System.out.println(name);
        }
    }

    private static boolean isGmail(String email) {
        Pattern pattern = Pattern.compile("[a-zA-Z0-9\\.]*@gmail.com");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

}
