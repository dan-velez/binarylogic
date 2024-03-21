package com.blit.exceptions;

public class InvalidVinException extends Exception {
    public InvalidVinException () {
        super();
    }

    public InvalidVinException (String message) {
        super(message);
    }
}
