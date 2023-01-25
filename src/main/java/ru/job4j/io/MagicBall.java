package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {
    public String giveAnswer() {
        return switch (new Random().nextInt(3)) {
            case 1 -> "Да";
            case 2 -> "Нет";
            default -> "Может быть";
        };
    }

    public static void main(String[] args) {
        MagicBall ball = new MagicBall();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Я великий Оракул. Что ты хочешь узнать? ");
        System.out.println(scanner.nextLine());
        System.out.println(ball.giveAnswer());
    }
}
