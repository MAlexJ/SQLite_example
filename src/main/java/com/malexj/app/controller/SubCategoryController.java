package com.malexj.app.controller;

import com.google.common.collect.Lists;
import com.malexj.app.dto.BuilderDTO;
import com.malexj.app.dto.PageDTO;
import com.malexj.app.dto.SubCategoryDTO;
import com.malexj.app.repository.SubCategoryDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.Callable;

import static com.malexj.app.constant.Constant.*;

@Slf4j
@RestController
public class SubCategoryController
{
    private final SubCategoryDao subCategory;

    @Autowired
    public SubCategoryController(SubCategoryDao subCategory)
    {
        this.subCategory = subCategory;
    }


    @GetMapping(value = "/app/subcategory/{subCategoryName}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Callable<PageDTO> getSubCategoriesByName(@PathVariable("subCategoryName") String subCategoryName)
    {
        List<SubCategoryDTO> subCategories;
        String html;

        switch (subCategoryName)
        {
            case SUB_DDL:
                subCategories = Lists.newArrayList(new SubCategoryDTO(1, "SQL Into"), new SubCategoryDTO(2, "SQL Syntax"));
                html = "<h1>Text</h1>" +
                        "<section class='row text-center placeholders'>" +
                        "Something text" +
                        "</section>";
                break;
            case SUB_DML:
                subCategories = Lists.newArrayList(new SubCategoryDTO(1, "SQL Create"), new SubCategoryDTO(2, "SQL Alter"));
                html = "<h1>Text DML</h1><p>SQL Create<p>";
                break;
            case SUB_DCL:
                subCategories = Lists.newArrayList(new SubCategoryDTO(1, "GRANT"), new SubCategoryDTO(2, "REVOKE"));
                html = "<h1>Text DCL</h1><p>SQL GRANT<p>";
                break;
            case SUB_TCL:
                subCategories = Lists.newArrayList(new SubCategoryDTO(1, "Commit"), new SubCategoryDTO(2, "Rollback"));
                html = "<h1>Text TCL</h1><p>SQL Commit<p>";
                break;
            default:
                log.error("Incorrect path: " + subCategoryName);
                subCategories = Lists.newArrayList();
                html = "error";

        }

        PageDTO page = new PageDTO(subCategories, html);
        return () -> page;
    }

    @PostMapping(value = "/app/subcategory/{subCategoryName}", consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Callable<BuilderDTO> postSubCategoriesByName(@PathVariable("subCategoryName") String subCategoryName)
    {
        return () -> subCategory.getListSubCategoriesByCategoryName(subCategoryName, 9);
    }
}
