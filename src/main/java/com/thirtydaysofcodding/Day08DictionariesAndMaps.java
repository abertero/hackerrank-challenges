package com.thirtydaysofcodding;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day08DictionariesAndMaps {
    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);
        Map<String, Integer> dictionary = new HashMap<>();
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            String name = in.next();
            int phone = in.nextInt();
            dictionary.put(name, phone);
            // Write code here
        }
        while (in.hasNext()) {
            String s = in.next();
            // Write code here
            if (dictionary.containsKey(s)) {
                System.out.println(String.format("%s=%s", s, dictionary.get(s)));
            } else {
                System.out.println("Not found");
            }
        }
        in.close();
    }
}
