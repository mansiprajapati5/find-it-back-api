package com.finditback.system.common.exception;

public class MissingParameter extends RuntimeException {

    public MissingParameter() {
    }

    public MissingParameter(String message) {
        super(message);
    }
}
