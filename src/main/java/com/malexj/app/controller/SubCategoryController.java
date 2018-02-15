package com.malexj.app.controller;

import com.google.common.collect.Lists;
import com.malexj.app.dto.SubCategoryDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.malexj.app.constant.Constant.*;

@Slf4j
@RestController
public class SubCategoryController {

    @GetMapping(value = "/app/subcategory/{subCategoryName}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public List<SubCategoryDTO> getSubCategoriesByName(@PathVariable("subCategoryName") String subCategoryName) {
        switch (subCategoryName) {
            case SUB_DDL:
                return Lists.newArrayList(new SubCategoryDTO(1, "SQL Into"), new SubCategoryDTO(2, "SQL Syntax"));
            case SUB_DML:
                return Lists.newArrayList(new SubCategoryDTO(1, "SQL Create"), new SubCategoryDTO(2, "SQL Alter"));
            case SUB_TCL:
                return Lists.newArrayList(new SubCategoryDTO(1, "Commit"), new SubCategoryDTO(2, "Rollback"));
            default:
                return Lists.newArrayList();
        }
    }

    @PostMapping(value = "/app/subcategory/{subCategoryName}")
    public void postSubCategoriesByName(@PathVariable("subCategoryName") String subCategoryName,
                                        @RequestParam(value = "text", required = false) String text) {
        System.out.println(" >>>>>>>>>>>>> subCategoryName: " + subCategoryName);
        System.out.println(" >>>>>>>>>>>>> text: " + text);
    }

}
