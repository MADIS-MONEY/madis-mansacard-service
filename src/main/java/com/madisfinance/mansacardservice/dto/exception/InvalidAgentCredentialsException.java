package com.madisfinance.mansacardservice.dto.exception;


public class InvalidAgentCredentialsException extends RuntimeException {
    public InvalidAgentCredentialsException(String message) {
        super(message);
    }

}
