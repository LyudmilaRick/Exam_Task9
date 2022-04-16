package ru.skypro;

public class NullElementException extends RuntimeException{
    public NullElementException() {
        super("Элемент НОЛЬ не допускается!");
    }
}
