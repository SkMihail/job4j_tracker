package ru.job4j.collection;

import java.util.Objects;

public final class Job implements Comparable<Job> {
    private final String name;
    private final int priority;

    public Job(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public String name() {
        return name;
    }

    public int priority() {
        return priority;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        var that = (Job) obj;
        return Objects.equals(this.name, that.name)
                && this.priority == that.priority;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, priority);
    }

    @Override
    public String toString() {
        return "Job["
                + "name=" + name + ", "
                + "priority=" + priority + ']';
    }

    @Override
    public int compareTo(Job another) {
        return Integer.compare(priority, another.priority);
    }
}
