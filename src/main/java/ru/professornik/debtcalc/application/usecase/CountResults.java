package ru.professornik.debtcalc.application.usecase;

import ru.professornik.debtcalc.application.model.ResultForPeople;

public interface CountResults {
    ResultForPeople execute(String buyerName);
}
