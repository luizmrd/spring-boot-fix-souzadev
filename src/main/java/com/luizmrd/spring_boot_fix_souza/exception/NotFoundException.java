package com.luizmrd.spring_boot_fix_souza.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
