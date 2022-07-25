package ru.professornik.debtcalc.application.usecase.impl;

import ru.professornik.debtcalc.application.model.PurchaseModel;
import ru.professornik.debtcalc.application.port.PersonGetaway;
import ru.professornik.debtcalc.application.port.PurchaseGetaway;
import ru.professornik.debtcalc.application.usecase.CreatePurchase;
import ru.professornik.debtcalc.domain.Person;
import ru.professornik.debtcalc.domain.Purchase;
import ru.professornik.debtcalc.domain.exception.InvalidPurchaseFormatException;

import java.util.List;
import java.util.stream.Collectors;

public class CreatePurchaseImpl implements CreatePurchase {
    private final PersonGetaway personGetaway;
    private final PurchaseGetaway purchaseGetaway;

    public CreatePurchaseImpl(PersonGetaway personGetaway, PurchaseGetaway purchaseGetaway) {
        this.personGetaway = personGetaway;
        this.purchaseGetaway = purchaseGetaway;
    }

    public void execute(PurchaseModel purchaseModel){
        var purchase = mapModelToEntity(purchaseModel);
        purchaseGetaway.save(purchase);
    }

    private Purchase mapModelToEntity(PurchaseModel purchaseModel){
        return Purchase.of(mapNameToPerson(purchaseModel.getBuyerName()),
                purchaseModel.getCost(),
                mapNamesToPeople(purchaseModel.getDebtors()));
    }

    private List<Person> mapNamesToPeople(List<String> peopleNames){
        return peopleNames.stream()
                .map(this::mapNameToPerson)
                .collect(Collectors.toList());
    }

    private Person mapNameToPerson(String name){
        var person = personGetaway.findByName(name);
        if(person.isEmpty()){
            throw new InvalidPurchaseFormatException("person with name " + name + " not exist");
        }
        return person.get();
    }
}
