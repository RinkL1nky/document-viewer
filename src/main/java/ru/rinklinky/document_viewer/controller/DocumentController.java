package ru.rinklinky.document_viewer.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import ru.rinklinky.document_viewer.baseresponse.BaseResponseService;
import ru.rinklinky.document_viewer.baseresponse.ResponseWrapper;
import ru.rinklinky.document_viewer.dto.DocumentDto;
import ru.rinklinky.document_viewer.service.DocumentService;

@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/documents")
public class DocumentController {
    private final BaseResponseService baseResponseService;
    private final DocumentService documentService;

    @GetMapping
    public ResponseWrapper<List<DocumentDto>> findAll() {
        return baseResponseService.wrapSuccessResponse(documentService.findAllDocuments());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseWrapper<DocumentDto> createDocument(@RequestBody @Valid DocumentDto documentDto) {
        return baseResponseService.wrapSuccessResponse(documentService.saveDocument(documentDto));
    }

    @PutMapping("/document/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateDocument(@RequestBody @Valid DocumentDto document) {
        documentService.updateDocument(document);
    }

    @DeleteMapping("/document/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDocument(@PathVariable @Min(0) Long id) {
        documentService.deleteDocumentById(id);
    }

}