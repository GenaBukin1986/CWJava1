package org.example;

public class CountNumberException extends RuntimeException{
    public CountNumberException() {
        super("Количество игрушек должно быть больше 0!");
    }

}
