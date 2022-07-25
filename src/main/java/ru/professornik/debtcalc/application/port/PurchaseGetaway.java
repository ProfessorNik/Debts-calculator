package ru.professornik.debtcalc.application.port;

import ru.professornik.debtcalc.domain.Person;
import ru.professornik.debtcalc.domain.Purchase;

import java.util.List;

public interface PurchaseGetaway {
    void save(Purchase purchase);
    List<Purchase> findAll();
    List<Purchase> findByBuyer(Person buyer);
}
