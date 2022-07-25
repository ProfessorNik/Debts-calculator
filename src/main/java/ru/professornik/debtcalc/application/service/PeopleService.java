package ru.professornik.debtcalc.application.service;

import ru.professornik.debtcalc.application.model.AvailablePeople;
import ru.professornik.debtcalc.application.port.PersonGetaway;
import ru.professornik.debtcalc.domain.Person;

public class PeopleService {
    private PersonGetaway personGetaway;

    public AvailablePeople getAvailablePeople() {
        return new AvailablePeople(personGetaway.findAll());
    }

}