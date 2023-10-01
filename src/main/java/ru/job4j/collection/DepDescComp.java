package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] o1Array = o1.split("/");
        String[] o2Array = o2.split("/");
        int result = o2Array[0].compareTo(o1Array[0]);
        if (result != 0) {
            return result;
        }
        if (Math.min(o1Array.length, o2Array.length) != 1) {
            for (int i = 1; i < Math.min(o1Array.length, o2Array.length); i++) {
                result = o1Array[i].compareTo(o2Array[i]);
                if (result != 0) {
                    return result;
                }
            }
        } else {
            result = Integer.compare(o1Array.length, o2Array.length);
        }
        return result;
    }
}

