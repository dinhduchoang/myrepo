package com.hoangd.identity_service.exception;

public class MyException extends RuntimeException{
    private ErrorCode errorCode;

    public MyException(ErrorCode errorCode){
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

}
