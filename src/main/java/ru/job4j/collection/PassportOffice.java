package ru.job4j.collection;

import java.util.*;

public class PassportOffice {
    private Map<String, Citizen> citizens = new HashMap<>();

    public boolean add(Citizen citizen) {
        boolean rsl = false;
        if (!citizens.containsKey(citizen.passport())) {
            citizens.put(citizen.passport(), citizen);
            rsl = true;
        }
        return rsl;
    }

    public Citizen get(String passport) {
        return citizens.get(passport);
    }
}
