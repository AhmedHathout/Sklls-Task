package com.ahmedhathout.skllstask.exceptions;

public class SkllsException extends RuntimeException {
    public SkllsException(String exMessage, Exception exception) {
        super(exMessage, exception);
    }

    public SkllsException(String exMessage) {
        super(exMessage);
    }
}