package ru.job4j.search;

import java.util.ArrayList;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> res = new ArrayList<>();
        for (Person x : persons) {
            if (x.getPhone().contains(key) || x.getName().contains(key)
               || x.getAddress().contains(key) || x.getSurname().contains(key)) {
                res.add(x);
            }
        }
        return res;
    }
}