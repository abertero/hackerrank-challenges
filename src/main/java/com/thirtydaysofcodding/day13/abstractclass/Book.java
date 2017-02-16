package com.thirtydaysofcodding.day13.abstractclass;


public abstract class Book {
    String title;
    String author;

    public Book(String t, String a) {
        title = t;
        author = a;
    }

    abstract void display();
}
