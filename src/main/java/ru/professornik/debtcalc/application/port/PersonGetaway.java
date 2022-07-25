package ru.professornik.debtcalc.application.port;

import ru.professornik.debtcalc.domain.Person;

import java.util.List;
import java.util.Optional;

public interface PersonGetaway {
    void save(Person user);
    Optional<Person> findByName(String name);
    List<Person> findAll();
}
