package com.algorithms.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Gemstones {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        scn.nextLine();
        boolean first = true;
        List<Character> possibleGemElements = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            String rock = scn.nextLine();
            analyzePossibleGemElements(possibleGemElements, rock, first);
            first = false;
            if (possibleGemElements.isEmpty()) {
                break;
            }
        }
        System.out.println(possibleGemElements.size());
        scn.close();
    }

    private static void analyzePossibleGemElements(List<Character> possibleGemElements, String rock, boolean first) {
        if (first) {
            for (int i = 0; i < rock.length(); i++) {
                if (!possibleGemElements.contains(rock.charAt(i))) {
                    possibleGemElements.add(rock.charAt(i));
                }
            }
        } else {
            List<Character> auxiliaryList = new ArrayList<>(possibleGemElements);
            for (int i = 0; i < auxiliaryList.size(); i++) {
                if (!rock.contains(auxiliaryList.get(i).toString())) {
                    possibleGemElements.remove(auxiliaryList.get(i));
                }
            }
        }
    }
}
