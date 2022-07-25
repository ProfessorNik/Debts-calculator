package ru.professornik.debtcalc.infrastructure.mapper;

import ru.professornik.debtcalc.application.model.PurchaseModel;
import ru.professornik.debtcalc.infrastructure.dto.PurchaseDto;

import java.math.BigDecimal;

public class PurchaseMapper {
    public static PurchaseModel toModel(PurchaseDto purchaseDto) {
        return new PurchaseModel(
                purchaseDto.getBuyerName(),
                new BigDecimal(purchaseDto.getCost()),
                purchaseDto.getDebtorsName()
        );
    }
}
