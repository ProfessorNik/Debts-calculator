package ru.professornik.debtcalc.domain;

import ru.professornik.debtcalc.domain.id.PersonId;

public class Person {
    private String name;

    private Person(String name) {
        this.name = name;
    }

    public static Person of(String name) {
        if(name == null){
            throw new NullPointerException("name is null");
        }
        return new Person(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
