package ru.professornik.debtcalc.infrastructure.controller;

import ru.professornik.debtcalc.application.usecase.CreatePurchase;
import ru.professornik.debtcalc.infrastructure.dto.PurchaseDto;
import ru.professornik.debtcalc.infrastructure.mapper.PurchaseMapper;

public class PurchaseController {
    private final CreatePurchase createPurchase;

    public PurchaseController(CreatePurchase createPurchase) {
        this.createPurchase = createPurchase;
    }

    public void createNewPurchase(PurchaseDto createPurchaseRequest){
        createPurchase.execute(PurchaseMapper.toModel(createPurchaseRequest));
    }
}
