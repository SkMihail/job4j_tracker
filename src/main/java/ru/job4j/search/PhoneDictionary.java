package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.BiPredicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        BiPredicate<Person, String> phone = (x, y) -> x.getPhone().contains(y);
        BiPredicate<Person, String> name = (x, y) -> x.getName().contains(y);
        BiPredicate<Person, String> address = (x, y) -> x.getAddress().contains(y);
        BiPredicate<Person, String> surname = (x, y) -> x.getSurname().contains(y);
        BiPredicate<Person, String> combine = (x, y) -> phone.test(x, y) || name.test(x, y)
                || address.test(x, y) || surname.test(x, y);
        ArrayList<Person> res = new ArrayList<>();
        for (Person x : persons) {
            if (combine.test(x, key)) {
                res.add(x);
            }
        }
        return res;
    }
}
