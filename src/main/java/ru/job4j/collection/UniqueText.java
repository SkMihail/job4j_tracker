package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;

public class UniqueText {
    public boolean isEquals(String originText, String duplicateText) {
        HashSet<String> origin = new HashSet<>(List.of(originText.split(" ")));
        HashSet<String> duplicate = new HashSet<>(List.of(duplicateText.split(" ")));
        return origin.containsAll(duplicate);
    }
}

