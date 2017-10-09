package com.amazon;

import java.util.Arrays;
import java.util.List;

/**
 * Created by aldo on 09-10-17.
 */
public class FruitCompany {

    public static void main(String[] args) {
        FruitCompany company = new FruitCompany();
        System.out.println(company.checkWinner(
                listOfList(
                        list("orange"),
                        list("apple", "apple"),
                        list("banana", "orange", "apple"),
                        list("banana")),
                list("orange", "apple", "apple", "banana", "orange", "apple", "banana")));
        System.out.println(company.checkWinner(
                listOfList(
                        list("orange"),
                        list("apple", "apple"),
                        list("banana", "orange", "apple"),
                        list("banana")),
                list("orange", "guava", "apple", "apple", "banana", "orange", "apple", "banana")));
        System.out.println(company.checkWinner(
                listOfList(
                        list("apple", "apricot"),
                        list("banana", "anything", "guava"),
                        list("papaya", "anything")),
                list("banana", "orange", "guava", "apple", "apricot", "papaya", "kiwi")));
        System.out.println(company.checkWinner(
                listOfList(
                        list("apple", "apricot"),
                        list("banana", "anything", "guava"),
                        list("papaya", "anything")),
                list("banana", "orange", "apple", "apricot", "apricot", "papaya", "banana", "papaya", "guava", "apple", "papaya", "orange")));
    }

    public static List<String> list(String... arr) {
        return Arrays.asList(arr);
    }

    public static List<List<String>> listOfList(List<String>... list) {
        return Arrays.asList(list);
    }

    public int checkWinner(List<List<String>> codeList, List<String> shoppingCart) {
        int index = 0;
        for (List<String> codes : codeList) {
            index = containsSubList(shoppingCart, codes, index);
            if (index == -1) {
                return 0;
            }
        }
        return 1;
    }

    private int containsSubList(List<String> shoppingCart, List<String> codes, int index) {
        if (index + codes.size() > shoppingCart.size()) {
            return -1;
        }
        for (int i = index; i < shoppingCart.size(); i++) {
            int j = i;
            boolean consecutive = true;
            for (String code : codes) {
                if (j >= shoppingCart.size()) {
                    consecutive = false;
                    break;
                }
                if ("anything".equals(code)) {
                    ++j;
                } else if (!code.equals(shoppingCart.get(j))) {
                    consecutive = false;
                    break;
                } else {
                    ++j;
                }
            }
            if (consecutive) {
                return j;
            }
        }
        return -1;
    }
}
