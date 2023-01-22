package ru.job4j.pojo;

public class Book {
    private final String title;
    private final int numOfPages;

    public Book(String title, int numOfPages) {
        this.title = title;
        this.numOfPages = numOfPages;
    }

    public String getTitle() {
        return title;
    }

    public int getNumOfPages() {
        return numOfPages;
    }
}
