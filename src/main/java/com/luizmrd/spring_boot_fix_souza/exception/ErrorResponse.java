package com.luizmrd.spring_boot_fix_souza.exception;

import lombok.*;

@Builder
@Getter
public class ErrorResponse {

    private String message;
    private Integer status;
}
