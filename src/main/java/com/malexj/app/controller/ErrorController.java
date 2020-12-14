package com.malexj.app.controller;

import com.malexj.app.dto.BuilderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class ErrorController
{

    /**
     * Handel errors and exceptions in app
     *
     * @return `error` page
     */
    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public BuilderDTO exception(final Throwable throwable)
    {
        log.error("Exception during execution of SpringSecurity application", throwable);
        String errorMessage = (throwable != null ? throwable.getMessage() : "Unknown error");
        return BuilderDTO.builder()
                .isError(true)
                .message(errorMessage)
                .build();
    }
}