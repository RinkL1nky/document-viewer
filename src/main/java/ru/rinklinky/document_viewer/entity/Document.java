package ru.rinklinky.document_viewer.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "documents")
public class Document {
    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "doc_seq_gen")
    @SequenceGenerator(name = "doc_seq_gen", sequenceName = "documents_seq", allocationSize = 50, initialValue = 10)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @NotNull
    @Column(name = "number", nullable = false)
    private String number;

    @NotBlank
    @Column(name = "type", nullable = false)
    private String type;

    @NotNull
    @Column(name = "name", nullable = false, columnDefinition = "TEXT")
    private String name;

    @NotNull
    @Column(name = "date", nullable = false)
    private LocalDate date;

    @NotNull
    @Column(name = "url", nullable = false, columnDefinition = "TEXT")
    private String url;

}