package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void drive() {
        System.out.println("Автобус едет");
    }

    @Override
    public void passenger(int amount) {
        System.out.println("Пассажиров в автобусе: " + amount);
    }

    @Override
    public double fuel(double volume) {
        double price = 60;
        return price * volume;
    }
}
