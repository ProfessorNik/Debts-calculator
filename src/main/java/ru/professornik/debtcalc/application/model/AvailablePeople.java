package ru.professornik.debtcalc.application.model;

import ru.professornik.debtcalc.domain.Person;

import java.util.List;

public class AvailablePeople {
    private List<Person> people;

    public AvailablePeople(List<Person> people) {
        this.people = people;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }
}
