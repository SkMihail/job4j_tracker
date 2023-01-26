package ru.job4j.poly;

public class Aircraft implements Vehicle {
    @Override
    public void move() {
        System.out.println("""
                Вижу голубеющую даль
                Нарушать такую просто жаль
                Жаль, что ты ее не видишь, путь мой труден и далек
                Мой "фантом" несется на восток
                """);
    }
}
