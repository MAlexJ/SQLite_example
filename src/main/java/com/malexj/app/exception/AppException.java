package com.malexj.app.exception;

import javax.annotation.Nonnull;

import static java.lang.String.format;

public class AppException extends RuntimeException {

    private final Object[] args;

    public AppException(@Nonnull final String messageTemplate, @Nonnull final Object... args) {
        super(messageTemplate);
        this.args = args;
    }

    @Override
    public String getMessage() {
        return format(super.getMessage(), args);
    }

}