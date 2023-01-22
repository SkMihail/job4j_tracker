package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        for (Item item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public Item[] findAll() {
        Item[] rsl = new Item[items.length];
        int size = 0;
        for (Item item : items) {
            if (item != null) {
                rsl[size] = item;
                size++;
            }
        }
        return Arrays.copyOf(rsl, size);
    }

    public Item[] findByName(String key) {
        if (key == null) {
            return new Item[0];
        }
        Item[] rsl = new Item[items.length];
        int size = 0;
        for (Item item : items) {
            if (item != null && key.equals(item.getName())) {
                rsl[size] = item;
                size++;
            }
        }
        return Arrays.copyOf(rsl, size);
    }

}