package ru.rinklinky.document_viewer.exception;

public class NotFoundException extends CommonException {

    public NotFoundException(String message) {
        super(ErrorType.NOT_FOUND, message);
    }

}