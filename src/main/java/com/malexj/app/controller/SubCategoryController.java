package com.malexj.app.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Lists;
import com.malexj.app.dto.SubCategoryDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.Callable;

import static com.malexj.app.constant.Constant.*;

@Slf4j
@RestController
public class SubCategoryController
{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SubCategoryController(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping(value = "/app/subcategory/{subCategoryName}", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public List<SubCategoryDTO> getSubCategoriesByName(@PathVariable("subCategoryName") String subCategoryName)
    {
        switch (subCategoryName)
        {
            case SUB_DDL:
                return Lists.newArrayList(new SubCategoryDTO(1, "SQL Into"), new SubCategoryDTO(2, "SQL Syntax"));
            case SUB_DML:
                return Lists.newArrayList(new SubCategoryDTO(1, "SQL Create"), new SubCategoryDTO(2, "SQL Alter"));
            case SUB_DCL:
                return Lists.newArrayList(new SubCategoryDTO(1, "GRANT"), new SubCategoryDTO(2, "REVOKE"));
            case SUB_TCL:
                return Lists.newArrayList(new SubCategoryDTO(1, "Commit"), new SubCategoryDTO(2, "Rollback"));
            default:
                log.error("Incorrect path: " + subCategoryName);
                return Lists.newArrayList();
        }
    }

    @PostMapping(value = "/app/subcategory/{subCategoryName}", consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Callable<String> postSubCategoriesByName(@PathVariable("subCategoryName") String subCategoryName, @RequestBody JsonNode node)
    {
        switch (subCategoryName)
        {
            case SUB_DDL:
                System.out.println(">>>>>>>>>>  subCategoryName " + subCategoryName + "  >>>>>>>>>>>  body: " + node.get("text"));
                break;
            case SUB_DML:
                System.out.println(">>>>>>>>>>  subCategoryName " + subCategoryName + "  >>>>>>>>>>>  body: " + node.get("text"));
                break;
            case SUB_DCL:
                System.out.println(">>>>>>>>>>  subCategoryName " + subCategoryName + "  >>>>>>>>>>>  body: " + node.get("text"));
                break;
            case SUB_TCL:
                System.out.println(">>>>>>>>>>  subCategoryName " + subCategoryName + "  >>>>>>>>>>>  body: " + node.get("text"));
                break;
            default:
                log.error("Incorrect path: " + subCategoryName);
        }

        System.out.println();
        int rowCount = jdbcTemplate.queryForObject("SELECT count(*) FROM categoryTable", Integer.class);
        System.out.println("<<<<<<<<<<<<<< rowCount: " + rowCount);
        System.out.println();

      return () -> "subCategoryName: " + subCategoryName + ", node: " + node;
    }
}
