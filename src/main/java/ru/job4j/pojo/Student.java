package ru.job4j.pojo;

import java.time.LocalDate;

public class Student {
    private String name;
    private LocalDate startEdu;
    private int group;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartEdu() {
        return startEdu;
    }

    public void setStartEdu(LocalDate startEdu) {
        this.startEdu = startEdu;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }
}
