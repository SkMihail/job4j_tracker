package ru.job4j.oop;

public class Cat {

    private String food;
    private String nick;

    public void show() {
        System.out.printf("Cat %s eats %s.%s", this.nick, this.food, System.lineSeparator());
    }

    public void eat(String meal) {
        this.food = meal;
    }

    public void giveNick(String nick) {
        this.nick = nick;
    }

    public static void main(String[] args) {
        System.out.println("There are gav's food.");
        Cat gav = new Cat();
        gav.giveNick("Gav");
        gav.eat("kotleta");
        gav.show();
        System.out.println("There are black's food.");
        Cat black = new Cat();
        black.giveNick("Black");
        black.eat("fish");
        black.show();
    }
}
