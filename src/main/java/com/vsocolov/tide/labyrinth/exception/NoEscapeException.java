package com.vsocolov.tide.labyrinth.exception;

public class NoEscapeException extends Exception {

    public NoEscapeException() {
        this("No escape paths exist!");
    }

    public NoEscapeException(final String msg) {
        super(msg);
    }
}
