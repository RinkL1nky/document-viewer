package ru.rinklinky.document_viewer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DocumentDto {

    @JsonProperty("id")
    private Long id;

    @NotNull
    @JsonProperty("number")
    private String number;

    @NotBlank
    @JsonProperty("type")
    private String type;

    @NotNull
    @JsonProperty("name")
    private String name;

    @NotBlank
    @JsonProperty("date")
    private String date;

    @NotBlank
    @JsonProperty("url")
    private String url;

}