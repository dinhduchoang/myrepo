package com.hoangd.identity_service.exception;

public enum ErrorCode {
    USER_EXISTED(1001, "User da ton tai (msg tu ErrorCode)"),
    USER_NOT_EXISTED(1002, "User khong ton tai (msg tu ErrorCode)"),
    USER_VALID_PASSWORD(1003, "GIA TRI KHONG HOP LE , Vui long nhap lai mat khau"),
    INVALID_KEY(1004, "LOI KHONG XAC DINH"),
    AUTHENTICATED(1005, "Khong the xac thuc");
    private int code;
    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
