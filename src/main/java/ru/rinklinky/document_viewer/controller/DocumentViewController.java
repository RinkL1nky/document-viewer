package ru.rinklinky.document_viewer.controller;

import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.rinklinky.document_viewer.dto.DocumentDto;
import ru.rinklinky.document_viewer.service.DocumentService;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
public class DocumentViewController {
    private final DocumentService documentService;

    @GetMapping("/")
    public String index(@RequestParam("fromDate") Optional<String> fromDate,
                        @RequestParam("toDate") Optional<String> toDate,
                        @RequestParam("number") Optional<String> number,
                        @RequestParam("type") Optional<String> type,
                        @RequestParam("name") Optional<String> name,
                        Model model) {
        String startDate = fromDate.orElse("4713-01-01 BC").strip();
        String endDate = toDate.orElse("5874897-01-01 AD").strip();
        String numberPattern = "%" + number.orElse("").strip() + "%";
        String typePattern = "%" + type.orElse("").strip() + "%";
        String namePattern = "%" + name.orElse("").strip() + "%";

        List<DocumentDto> docs = documentService.filterDocuments(startDate, endDate,
                                                                 numberPattern, typePattern, namePattern);
        model.addAttribute("docs", docs);

        return "index";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable @Min(0) Long id, Model model) {
        DocumentDto doc = documentService.findDocumentById(id);
        model.addAttribute("doc", doc);
        return "edit";
    }

    @GetMapping("/add")
    public String add() {
        return "add";
    }

    @GetMapping("favicon.ico")
    @ResponseBody
    void returnNoFavicon() {}

}