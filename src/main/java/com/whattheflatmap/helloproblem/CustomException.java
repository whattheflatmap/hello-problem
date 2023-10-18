package com.whattheflatmap.helloproblem;

public class CustomException extends RuntimeException {
    public CustomException() {
    }

    public CustomException(final Throwable cause) {
        super(cause);
    }
}
