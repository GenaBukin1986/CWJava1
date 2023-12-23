package org.example;

public class IdNumberException extends RuntimeException{
    public IdNumberException() {
        super("Id не может быть отрицательным числом!");
    }
}
