package com.zzb.demo.response;

public enum Message {

    SUCCESS(200, "成功"),

    FAIL_INTERNAL_SERVER_ERROR(500, "Internal server error");

    public int code;
    public String message;

    Message(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
