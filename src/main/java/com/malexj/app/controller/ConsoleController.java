package com.malexj.app.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.malexj.app.dto.BuilderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

/**
 * API for `console` page
 */
@Slf4j
@RestController
public class ConsoleController
{
    @PostMapping(value = "/app/subcategory/console",
            consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE},
            produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public Callable<BuilderDTO> geQuery(@RequestBody JsonNode node)
    {
        String query = node.get("query").asText();
        return () -> BuilderDTO.builder()
                .message("Successful: " + query)
                .build();
    }
}
