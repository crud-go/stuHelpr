package com.ujs.stupool.model.response;

public class CommonRes {
    int code;
    String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public CommonRes(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
