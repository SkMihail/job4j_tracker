package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import java.util.Comparator;
import static org.assertj.core.api.Assertions.assertThat;

class JobTest {

    @Test
    public void whenCompareByPriorityAndName() {
        Comparator<Job> cmpNamePriority =  new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenCompareByDescPriority() {
        Comparator<Job> cmpNamePriority =  new JobDescByPriority();
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenCompareByIncrPriority() {
        Comparator<Job> cmpNamePriority =  new JobIncrByPriority();
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenCompareByIncrPriorityAndEqual() {
        Comparator<Job> cmpNamePriority =  new JobIncrByPriority();
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 1),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isEqualTo(0);
    }

    @Test
    public void whenCompareByDescName() {
        Comparator<Job> cmpNamePriority =  new JobDescByName();
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 1),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenCompareByIncrName() {
        Comparator<Job> cmpNamePriority =  new JobIncrByName();
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 1),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenCompareByIncrNameAndIncrPriority() {
        Comparator<Job> cmpNamePriority =  new JobIncrByName().thenComparing(new JobIncrByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Iix bug", 1),
                new Job("Iix bug", 0)
        );
        assertThat(rsl).isGreaterThan(0);
    }
}