package ru.job4j.poly;

public interface Transport {
    void drive();

    void passenger(int amount);

    double fuel(double volume);

}
