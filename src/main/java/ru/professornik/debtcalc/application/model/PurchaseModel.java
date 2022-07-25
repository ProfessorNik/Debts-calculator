package ru.professornik.debtcalc.application.model;

import java.math.BigDecimal;
import java.util.List;

public class PurchaseModel {
    private String buyerName;
    private BigDecimal cost;
    private List<String> debtors;

    public PurchaseModel(String buyerName, BigDecimal cost, List<String> debtors) {
        this.buyerName = buyerName;
        this.cost = cost;
        this.debtors = debtors;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public List<String> getDebtors() {
        return debtors;
    }

    public void setDebtors(List<String> debtors) {
        this.debtors = debtors;
    }
}
