package com.example.techiteasymodel.exceptions;

public class IllegalNameLengthException extends RuntimeException{
    public IllegalNameLengthException() {
        super();
    }
    public IllegalNameLengthException(String message) {
        super(message);
    }
}
