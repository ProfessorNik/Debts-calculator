package ru.professornik.debtcalc.application.usecase.impl;

import ru.professornik.debtcalc.application.port.PersonGetaway;
import ru.professornik.debtcalc.application.usecase.CreatePerson;
import ru.professornik.debtcalc.domain.Person;

public class CreatePersonImpl implements CreatePerson {
    private final PersonGetaway personGetaway;

    public CreatePersonImpl(PersonGetaway personGetaway) {
        this.personGetaway = personGetaway;
    }


    @Override
    public void execute(String name) {
        var newPerson = Person.of(name);
        personGetaway.save(newPerson);
    }
}
