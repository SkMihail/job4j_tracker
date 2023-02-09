package ru.job4j.tracker;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class ItemTest {

    @Test
    public void whenIncreaseItem() {
        List<Item> items = Arrays.asList(new Item("BReplaced item"),
                new Item("AReplaced item"),
                new Item("CReplaced item"));
        Collections.sort(items, new ItemAscByName());
        List<Item> expected = Arrays.asList(new Item("AReplaced item"),
                new Item("BReplaced item"),
                new Item("CReplaced item"));
        assertThat(items.toString()).isEqualTo(expected.toString());
    }

    @Test
    public void whenDecreaseItem() {
        List<Item> items = Arrays.asList(new Item("BReplaced item"),
                new Item("AReplaced item"),
                new Item("CReplaced item"));
        Collections.sort(items, new ItemDescByName());
        List<Item> expected = Arrays.asList(new Item("CReplaced item"),
                new Item("BReplaced item"),
                new Item("AReplaced item"));
        assertThat(items.toString()).isEqualTo(expected.toString());
    }
}