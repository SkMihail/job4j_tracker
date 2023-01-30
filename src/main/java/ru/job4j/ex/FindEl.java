package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (key.equals(value[i])) {
                rsl = i;
                break;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("Такого ключа в массиве нет.");
        }
        return rsl;
    }

    public static void main(String[] args) {
        try {
            System.out.println(indexOf(new String[]{"test", "test2"}, "test"));
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }

        try {
            indexOf(new String[]{"test", "test2"}, "name");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
