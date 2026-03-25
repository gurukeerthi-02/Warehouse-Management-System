package com.example.warehouseinventorymanagementbackend.exception;

import org.springframework.web.bind.annotation.RestControllerAdvice;


public class InsufficientStockException extends RuntimeException {
    public InsufficientStockException(String message) {
        super(message);
    }
}
