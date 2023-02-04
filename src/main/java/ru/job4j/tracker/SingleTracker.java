package ru.job4j.tracker;

import java.util.List;

public final class SingleTracker {
    public static SingleTracker singleTracker = null;
    private Tracker tracker = new Tracker();

    private SingleTracker() {
    }

    public SingleTracker getInstance() {
        if (singleTracker == null) {
            singleTracker = new SingleTracker();
        }
        return singleTracker;
    }
    
    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public boolean replace(int id, Item replacement) {
        return tracker.replace(id, replacement);
    }
    
    public boolean delete(int id) {
        return tracker.delete(id);
    }
    
    public List<Item> findAll() {
        return tracker.findAll();
    }
    
    public List<Item> findByName(String key) {
        return tracker.findByName(key);
    }
}
