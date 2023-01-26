package ru.job4j.poly;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println("""
                Медленно минуты уплывают в даль,
                Встречи с ними ты уже не жди.
                И хотя нам прошлое немного жаль,
                Лучшее, конечно, впереди.
                """);
    }
}
