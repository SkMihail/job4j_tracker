package ru.job4j.ooa;

public final class Airbus extends Aircraft {
    private static final int COUNT_ENGINE = 2;

    private String name;

    public Airbus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void printModel() {
        super.printModel();
        System.out.println(name);
    }

    public void printCountEngine() {
        int x = this.getName().equals("A380") ? 4 : COUNT_ENGINE;
        System.out.println("Количество двигателей равно: " + x);
    }

    @Override
    public String toString() {
        return "Airbus{"
                + "name='" + name + '\''
                + '}';
    }

}
