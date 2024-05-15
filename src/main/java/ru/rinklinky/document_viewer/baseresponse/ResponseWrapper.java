package ru.rinklinky.document_viewer.baseresponse;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseWrapper<T> {

    private boolean success;
    private T body;
    private ErrorDto error;

}