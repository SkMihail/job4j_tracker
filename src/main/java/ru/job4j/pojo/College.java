package ru.job4j.pojo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class College {
    public static void main(String[] args) {
        Student jonSnow = new Student();
        jonSnow.setName("Jon Snow");
        jonSnow.setGroup(1);
        jonSnow.setStartEdu(LocalDate.parse("1970-01-01"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy");
        String dateOfStartEdu = jonSnow.getStartEdu().format(formatter);
        System.out.println(jonSnow.getName());
        System.out.println((jonSnow.getGroup()));
        System.out.println(dateOfStartEdu);
    }
}
