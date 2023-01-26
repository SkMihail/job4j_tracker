package ru.job4j.oop;

public class Freshman extends Student {

    @Override
    public void music() {
        System.out.println("Freshman music");
    }

    @Override
    public void sing() {
        super.sing();
    }
}
