package com.posrocket.assesment.exceptions;

public class WrongFileTypeException extends RuntimeException {
    public WrongFileTypeException(String message) {
        super(message);
    }
}
