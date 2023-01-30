package ru.job4j.tracker;

public class ValidateInput implements Input {
    private final Input in;
    private final Output out;

    public ValidateInput(Input input, Output out) {
        this.in = input;
        this.out = out;
    }

    @Override
    public String askStr(String question) {
        return in.askStr(question);
    }

    @Override
    public int askInt(String question) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = in.askInt(question);
                invalid = false;
            } catch (NumberFormatException nfe) {
                out.println("Please enter valid data");
            }
        } while (invalid);
        return value;
    }
}
