package com.malexj.app.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.malexj.app.dto.BuilderDTO;
import com.malexj.app.service.ConsoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

/**
 * API for `console` page
 */
@Api(value = "/app/subcategory/console", description = "Work with the input form to send SQL query.")
@Slf4j
@RestController
public class ConsoleController
{
    private final ConsoleService service;

    @Autowired
    public ConsoleController(ConsoleService service)
    {
        this.service = service;
    }

    @ApiOperation(value = "Get a response using the Json objecte", produces = "application/json;charset=UTF-8")
    @PostMapping(value = "/app/subcategory/console",
            consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE},
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Callable<BuilderDTO> getQuery(@RequestBody JsonNode node)
    {
        String query = node.get("query").asText();
        return () -> service.executeQuery(query);
    }
}
