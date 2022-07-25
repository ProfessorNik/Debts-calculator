package ru.professornik.debtcalc.application.usecase;

import ru.professornik.debtcalc.application.model.PurchaseModel;

public interface CreatePurchase {
    void execute(PurchaseModel purchaseModel);
}
