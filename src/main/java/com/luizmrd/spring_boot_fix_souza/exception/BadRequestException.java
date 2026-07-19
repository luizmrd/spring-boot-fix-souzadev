package com.luizmrd.spring_boot_fix_souza.exception;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}
