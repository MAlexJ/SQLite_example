package com.malexj.app.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.malexj.app.dto.BuilderDTO;
import com.malexj.app.repository.SubCategoryDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.Callable;

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
    public Callable<BuilderDTO> getSubCategoriesByName(@PathVariable("subCategoryName") String subCategoryName)
    {
        // todo >> comments
        //  1. WHY all data for subcategory include html
        //  2. change path to '/app/subcategories/{subCategoryName}'
        return () -> subCategory.getListCategoriesByCategoryName(subCategoryName);
    }

    @PostMapping(value = "/app/subcategory/{subCategoryName}", consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Callable<BuilderDTO> postSubCategoriesByName(@PathVariable("subCategoryName") String subCategoryName, @RequestBody JsonNode node)
    {
        // todo >> comments
        //  1. change path to '/app/subcategories/{subCategoryName}'
        int idSubCategory = node.get("idSubCategory").asInt();
        return () -> subCategory.getHtmlSubCategoriesByIdSubCategory(idSubCategory);
    }
}
