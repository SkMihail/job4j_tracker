package ru.job4j.collection;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class FullSearchTest {

    @Test
    public void extractNumber() {
        List<Task> tasks = Arrays.asList(
                new Task("1", "First desc"),
                new Task("2", "Second desc"),
                new Task("1", "First desc")
        );
        Set<Task> expected = Set.of(
                new Task("1", "First desc"),
                new Task("2", "Second desc")
        );
        assertThat(FullSearch.extractTask(tasks)).containsAll(expected);
    }
}