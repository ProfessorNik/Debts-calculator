package ru.professornik.debtcalc.application.model;

import java.math.BigDecimal;
import java.util.Map;

public class ResultForPeople {

    private String buyerName;
    private Map<String, BigDecimal> debts;

    public ResultForPeople(String buyerName, Map<String, BigDecimal> debts) {
        this.buyerName = buyerName;
        this.debts = debts;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public Map<String, BigDecimal> getDebts() {
        return debts;
    }

    public void setDebts(Map<String, BigDecimal> debts) {
        this.debts = debts;
    }

}
