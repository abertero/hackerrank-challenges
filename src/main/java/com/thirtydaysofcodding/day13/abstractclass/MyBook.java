package com.thirtydaysofcodding.day13.abstractclass;

/**
 * Created by aldo on 16-02-17.
 */
public class MyBook extends Book {
    private final int price;

    public MyBook(String title, String author, int price) {
        super(title, author);
        this.price = price;
    }

    @Override
    public void display() {
        System.out.println(String.format("Title: %s", title));
        System.out.println(String.format("Author: %s", author));
        System.out.println(String.format("Price: %s", price));
    }
}
