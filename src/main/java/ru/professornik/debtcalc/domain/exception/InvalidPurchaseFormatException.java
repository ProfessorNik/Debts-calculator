package ru.professornik.debtcalc.domain.exception;

public class InvalidPurchaseFormatException extends RuntimeException {
    public InvalidPurchaseFormatException() {
    }

    public InvalidPurchaseFormatException(String message) {
        super(message);
    }

    public InvalidPurchaseFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidPurchaseFormatException(Throwable cause) {
        super(cause);
    }
}
