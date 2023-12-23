package org.example;

public class ChangeToyException extends RuntimeException{
    public ChangeToyException() {
        super("Вы ввели число не входящее в диапазон от 1 до 100");
    }
}
