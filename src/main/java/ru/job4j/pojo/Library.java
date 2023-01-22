package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book efremov = new Book("Таис Афинская", 480);
        Book lem = new Book("Солярис", 285);
        Book levi = new Book("Искуство быть другим", 384);
        Book martin = new Book("Clean code", 461);
        Book[] shelfBook = {efremov, lem, levi, martin};
        System.out.println("Книги на полке:");
        for (int i = 0; i < shelfBook.length; i++) {
            System.out.println("Название: " + shelfBook[i].getTitle()
                    + ", количество страниц:" + shelfBook[i].getNumOfPages());
        }
        System.out.println("Переставим книги на полке:");
        Book temp = shelfBook[0];
        shelfBook[0] = shelfBook[3];
        shelfBook[3] = temp;
        for (int i = 0; i < shelfBook.length; i++) {
            System.out.println("Название: " + shelfBook[i].getTitle()
                    + ", количество страниц:" + shelfBook[i].getNumOfPages());
        }
        System.out.println("Выведем книги с названием \"Clean code\":");
        for (Book book : shelfBook) {
            if ("Clean code".equals(book.getTitle())) {
                System.out.println("Название: " + book.getTitle()
                        + ", количество страниц:" + book.getNumOfPages());
            }
        }
    }
}
