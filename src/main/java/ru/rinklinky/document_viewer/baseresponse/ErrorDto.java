package ru.rinklinky.document_viewer.baseresponse;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorDto {
    private String status;
    private String title;
    private String text;
}