package org.skypro.skyshop.exception;

public class BestResultNotFound extends Exception {
    public BestResultNotFound(String search) {
        super("Не найден подходящий результат для запроса: " + search);
    }
}
