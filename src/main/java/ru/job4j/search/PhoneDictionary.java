package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> phone = (x) -> x.getPhone().contains(key);
        Predicate<Person> name = (x) -> x.getName().contains(key);
        Predicate<Person> address = (x) -> x.getAddress().contains(key);
        Predicate<Person> surname = (x) -> x.getSurname().contains(key);
        Predicate<Person> combine = phone.or(name).or(address).or(surname);
        var res = new ArrayList<Person>();
        for (var x : persons) {
            if (combine.test(x)) {
                res.add(x);
            }
        }
        return res;
    }
}
