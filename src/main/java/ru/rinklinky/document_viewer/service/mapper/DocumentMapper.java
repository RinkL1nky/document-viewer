package ru.rinklinky.document_viewer.service.mapper;

import org.mapstruct.Mapper;
import ru.rinklinky.document_viewer.dto.DocumentDto;
import ru.rinklinky.document_viewer.entity.Document;
import java.util.List;

@Mapper(componentModel = "spring")
public interface DocumentMapper {

    DocumentDto toDto(Document document);
    Document toEntity(DocumentDto documentDto);
    List<DocumentDto> toDtoList(List<Document> documents);
    List<Document> toEntityList(List<DocumentDto> documents);

}