package com.thirtydaysofcodding.day21.generics;

public class Printer<T> {

    public void printArray(final T[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
