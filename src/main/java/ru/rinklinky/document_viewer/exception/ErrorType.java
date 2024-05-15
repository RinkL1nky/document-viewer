package ru.rinklinky.document_viewer.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
@RequiredArgsConstructor
public enum ErrorType {
    SERVER_ERROR("Service error", "Try again later", HttpStatusCode.valueOf(500)),
    NOT_FOUND("Not found", "Requested resource not found", HttpStatusCode.valueOf(404)),
    CLIENT_ERROR("Bad request", "Check request properties and try again", HttpStatus.valueOf(400));

    private final String title;
    private final String text;
    private final HttpStatusCode code;
}