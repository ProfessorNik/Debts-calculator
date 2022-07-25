package ru.professornik.debtcalc.application.usecase.impl;

import ru.professornik.debtcalc.application.model.ResultForPeople;
import ru.professornik.debtcalc.application.port.PersonGetaway;
import ru.professornik.debtcalc.application.port.PurchaseGetaway;
import ru.professornik.debtcalc.application.usecase.CountResults;
import ru.professornik.debtcalc.domain.Person;
import ru.professornik.debtcalc.domain.Purchase;
import ru.professornik.debtcalc.domain.exception.PersonNotFoundException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountResultsImpl implements CountResults {
    private final PurchaseGetaway purchaseGetaway;
    private final PersonGetaway personGetaway;

    public CountResultsImpl(PurchaseGetaway purchaseGetaway, PersonGetaway personGetaway) {
        this.purchaseGetaway = purchaseGetaway;
        this.personGetaway = personGetaway;
    }

    @Override
    public ResultForPeople execute(String buyerName) {
        var buyer = findPersonByName(buyerName);
        var purchases = purchaseGetaway.findByBuyer(buyer);
        var debts = countDebts(purchases);

        return new ResultForPeople(buyer.getName(), debts);
    }

    private Map<String, BigDecimal> countDebts(List<Purchase> purchases){
        var debts = new HashMap<String, BigDecimal>();
        for(var purchase : purchases){
            var debtors = purchase.getDebtors();
            var numberOfPurchaseParticipants = BigDecimal.valueOf(debtors.size());
            var payEachPerson = purchase.getCost().divide(numberOfPurchaseParticipants, RoundingMode.HALF_UP);
            for(var debtor : debtors) {
                var debtorName = debtor.getName();
                var newValue = debts.computeIfPresent(debtorName, (key, value) -> value.add(payEachPerson));
                if(newValue == null) {
                    debts.put(debtorName, payEachPerson);
                }
            }
        }
        return debts;
    }

    private Person findPersonByName(String personName){
        var personOpt = personGetaway.findByName(personName);
        if(personOpt.isEmpty()){
            throw new PersonNotFoundException("person with name" + personName + "not found");
        }
        return personOpt.get();
    }
}
