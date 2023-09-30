package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int result = o2.substring(0, 2).compareTo(o1.substring(0, 2));
        if (result == 0) {
            result = o1.substring(2).compareTo(o2.substring(2));
        }
        return result;
    }
}

