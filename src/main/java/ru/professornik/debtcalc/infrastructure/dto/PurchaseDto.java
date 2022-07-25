package ru.professornik.debtcalc.infrastructure.dto;

import java.util.List;

public class PurchaseDto {
    private String buyerName;
    private String cost;
    private List<String> debtorsName;

    public PurchaseDto(String buyerName, String cost, List<String> debtorsName) {
        this.buyerName = buyerName;
        this.cost = cost;
        this.debtorsName = debtorsName;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public List<String> getDebtorsName() {
        return debtorsName;
    }

    public void setDebtorsName(List<String> debtorsName) {
        this.debtorsName = debtorsName;
    }
}
