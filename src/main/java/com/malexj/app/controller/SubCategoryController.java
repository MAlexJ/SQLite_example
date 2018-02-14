package com.malexj.app.controller;

import com.malexj.app.dto.SubCategoryDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import static com.malexj.app.constant.Constant.*;

@Slf4j
@RestController
public class SubCategoryController {

    @GetMapping(value = "/app/subcategory/{subCategoryName}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Flux<SubCategoryDTO> getSubCategoriesByName(@PathVariable("subCategoryName") String subCategoryName) {
        switch (subCategoryName) {
            case SUB_DDL:
                return Flux.just(new SubCategoryDTO(1, "SQL Into"), new SubCategoryDTO(2, "SQL Syntax"));
            case SUB_DML:
                return Flux.just(new SubCategoryDTO(1, "SQL Create"), new SubCategoryDTO(2, "SQL Alter"));
            case SUB_TCL:
                return Flux.just(new SubCategoryDTO(1, "Commit"), new SubCategoryDTO(2, "Rollback"));
            default:
                return Flux.empty();
        }
    }
}
