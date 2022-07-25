package ru.professornik.debtcalc.domain;

import ru.professornik.debtcalc.domain.exception.InvalidPurchaseFormatException;

import java.math.BigDecimal;
import java.util.List;

public class Purchase {
    private Person buyer;
    private BigDecimal cost;
    private List<Person> debtors;

    private Purchase(Person buyer, BigDecimal cost, List<Person> debtors) {
        this.buyer = buyer;
        this.cost = cost;
        this.debtors = debtors;
    }

    public Person getBuyer() {
        return buyer;
    }

    public void setBuyer(Person buyer) {
        this.buyer = buyer;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public List<Person> getDebtors() {
        return debtors;
    }

    public void setDebtors(List<Person> debtors) {
        this.debtors = debtors;
    }


    public static Purchase of(Person buyer, BigDecimal cost, List<Person> debtors){
        if(buyer == null || cost == null || debtors == null){
            throw new NullPointerException();
        }

        if(debtors.contains(buyer)){
            throw new InvalidPurchaseFormatException("Buyer can't be debtor");
        }

        if(cost.compareTo(BigDecimal.ZERO) <= 0){
            throw new InvalidPurchaseFormatException("Invalid cost: " + cost);
        }

        return new Purchase(buyer, cost, debtors);
    }
}
