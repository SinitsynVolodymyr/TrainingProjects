package com.view;

public enum WrongRequest {

    WRONG_REQUEST("input.wrong"),;

    String keys;

    WrongRequest(String keys) {
        this.keys = keys;
    }

    public String getKey() {
        return keys;
    }

}
