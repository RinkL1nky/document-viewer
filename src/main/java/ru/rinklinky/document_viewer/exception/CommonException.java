package ru.rinklinky.document_viewer.exception;

import lombok.Getter;

@Getter
public class CommonException extends RuntimeException {
    private final ErrorType type;
    private final boolean userMessage;

    public CommonException(ErrorType type, String message) {
        super(message);
        this.type = type;
        this.userMessage = true;
    }

    public CommonException(ErrorType type, Throwable throwable) {
        super(throwable);
        this.type = type;
        this.userMessage = false;
    }

}