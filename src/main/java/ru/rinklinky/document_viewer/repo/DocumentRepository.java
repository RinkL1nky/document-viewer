package ru.rinklinky.document_viewer.repo;

import org.springframework.data.jpa.repository.Query;
import ru.rinklinky.document_viewer.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long>{

    @Query(value = "SELECT * FROM documents WHERE " +
                    "number ILIKE :numberPattern " +
                    "AND type ILIKE :typePattern " +
                    "AND name ILIKE :namePattern " +
                    "AND date >= CAST(:startDate AS DATE) " +
                    "AND date <= CAST(:endDate AS DATE)", nativeQuery = true)
    List<Document> searchByPatterns(String startDate, String endDate, String numberPattern,
                                    String typePattern, String namePattern);

    @Query(value = "SELECT EXISTS (SELECT id FROM documents WHERE " +
                    "number = :number " +
                    "AND type = :type " +
                    "AND name = :name " +
                    "AND date = CAST(:dateString AS DATE) " +
                    "AND url = :url)", nativeQuery = true)
    boolean checkExistence(String number, String type, String name, String dateString, String url);

}