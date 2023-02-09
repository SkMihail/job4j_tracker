package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        int res;
        for (int i = 0; i < Math.min(o1.length(), o2.length()); i++) {
            res = Character.compare(o1.charAt(i), o2.charAt(i));
            if (res != 0) {
                return res;
            }
        }
        return Integer.compare(o1.length(), o2.length());
    }
}
