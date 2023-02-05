package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;

public class FullSearch {
    public static HashSet<Task> extractTask(List<Task> list) {
        return new HashSet<>(list);
    }
}
