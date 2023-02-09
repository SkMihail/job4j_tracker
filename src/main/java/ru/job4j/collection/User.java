package ru.job4j.collection;

import java.util.Objects;

public final class User implements Comparable<User> {
    private final String name;
    private final int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String name() {
        return name;
    }

    public int age() {
        return age;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        var that = (User) obj;
        return Objects.equals(this.name, that.name)
                && this.age == that.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "User["
                + "name=" + name + ", "
                + "age=" + age + ']';
    }

    @Override
    public int compareTo(User o) {
        int x = name().compareTo(o.name);
        return x != 0 ? x : Integer.compare(age(), o.age);
    }
}
