package ru.rinklinky.document_viewer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rinklinky.document_viewer.dto.DocumentDto;
import ru.rinklinky.document_viewer.entity.Document;
import ru.rinklinky.document_viewer.exception.CommonException;
import ru.rinklinky.document_viewer.exception.ErrorType;
import ru.rinklinky.document_viewer.exception.NotFoundException;
import ru.rinklinky.document_viewer.repo.DocumentRepository;
import ru.rinklinky.document_viewer.service.mapper.DocumentMapper;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DocumentService {
    private final DocumentRepository documentRepository;
    private final DocumentMapper documentMapper;

    public List<DocumentDto> findAllDocuments() {
        return documentMapper.toDtoList(documentRepository.findAll());
    }

    public List<DocumentDto> filterDocuments(String startDate, String endDate, String numberPattern,
                                             String typePattern, String namePattern) {
        List<Document> docs = documentRepository.searchByPatterns(startDate, endDate, numberPattern, typePattern, namePattern);
        return documentMapper.toDtoList(docs);
    }

    public DocumentDto saveDocument(DocumentDto documentDto) {
        documentDto.setNumber(documentDto.getNumber().strip());
        documentDto.setType(documentDto.getType().strip());
        documentDto.setName(documentDto.getName().strip());
        documentDto.setDate(documentDto.getDate().strip());
        documentDto.setUrl(documentDto.getUrl().strip());

        if(documentRepository.checkExistence(documentDto.getNumber(), documentDto.getType(),
                                             documentDto.getName(), documentDto.getDate(), documentDto.getUrl())) {
            throw new CommonException(ErrorType.CLIENT_ERROR, "Document already exists");
        }
        Document document = documentMapper.toEntity(documentDto);
        return documentMapper.toDto(documentRepository.save(document));
    }

    public void updateDocument(DocumentDto newDocument) {
        Document oldDocument = documentRepository.findById(newDocument.getId())
                .orElseThrow(() -> new NotFoundException("Document not found"));

        oldDocument.setNumber(newDocument.getNumber().strip());
        oldDocument.setType(newDocument.getType().strip());
        oldDocument.setName(newDocument.getName().strip());
        oldDocument.setDate(LocalDate.parse(newDocument.getDate().strip()));
        oldDocument.setUrl(newDocument.getUrl().strip());

        documentRepository.save(oldDocument);
    }

    public DocumentDto findDocumentById(Long id) {
        Document doc = documentRepository.findById(id).
                orElseThrow(() -> new NotFoundException("Document not found"));
        return documentMapper.toDto(doc);
    }

    public void deleteDocumentById(Long id) {
        documentRepository.deleteById(id);
    }
}