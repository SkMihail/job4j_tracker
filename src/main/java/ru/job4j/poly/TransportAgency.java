package ru.job4j.poly;

public class TransportAgency {
    public static void main(String[] args) {
        Vehicle fantom = new Aircraft();
        Vehicle train = new Train();
        Vehicle schoolBus = new Bus();
        Vehicle[] arr = {fantom, train, schoolBus};
        for (Vehicle x : arr) {
            x.move();
        }
    }
}
