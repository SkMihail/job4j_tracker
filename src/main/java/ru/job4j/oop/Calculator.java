package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int divide(int y) {
        return y / x;
    }

    public int multiply(int y) {
        return y / x;
    }

    public int sumAllOperation(int y) {
        return sum(y) + minus(y) + divide(y) + multiply(y);
    }

    public static int minus(int y) {
        return y - x;
    }

    public static void main(String[] args) {
        System.out.println(minus(17));
        System.out.println(sum(17));
        Calculator calc = new Calculator();
        System.out.println(calc.divide(17));
        System.out.println(calc.multiply(17));
        System.out.println(calc.sumAllOperation(17));
    }

}

