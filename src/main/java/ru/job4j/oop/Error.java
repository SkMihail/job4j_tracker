package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println(message);
        System.out.println("Поле active = " + active);
        System.out.println("Поле status = " + status);
        System.out.println();
    }

    public static void printEveryInfo(Error... errors) {
        for (Error x : errors) {
            x.printInfo();
        }
    }

    public static void main(String[] args) {
        Error light = new Error(true, 10, "Light error");
        Error soft = new Error(true, 100, "Soft error");
        Error hard = new Error(true, 100500, "Hard error");
        Error noError = new Error(false, 0, "Everything is good");
        Error nothing = new Error();
        printEveryInfo(light, soft, hard, noError, nothing);

    }
}
