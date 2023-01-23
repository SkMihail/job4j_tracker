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
            if (isIdExist(item, id)) {
                return item;
            }
        }
        return null;
    }

    private boolean isIdExist(Item item, int id) {
        return item != null && item.getId() == id;
    }

    public boolean replace(int id, Item newItem) {
        for (Item item : items) {
            if (isIdExist(item, id)) {
                item.setName(newItem.getName());
                return true;
            }
        }
        return false;
    }

    public boolean delete(int id) {
        for (int i = 0; i < items.length; i++) {
            if (isIdExist(items[i], id)) {
                items[i] = null;
                return true;
            }
        }
        return false;
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