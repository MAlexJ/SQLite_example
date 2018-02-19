package com.malexj.app.service.impl;

import com.malexj.app.exception.AppException;
import com.malexj.app.service.IPropertiesReaderApp;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import javax.annotation.PostConstruct;
import java.util.ResourceBundle;

import static com.malexj.app.constant.Constant.ROOT_PROPERTY_FILE;

@Service
public class PropertiesReaderApp implements IPropertiesReaderApp {

    private ResourceBundle resourceBundle;

    @PostConstruct
    void initResourceBundle() {
        resourceBundle = ResourceBundle.getBundle(ROOT_PROPERTY_FILE);
        if (resourceBundle == null) {
            throw new AppException("Could not load any resources with name: %s", ROOT_PROPERTY_FILE);
        }
    }

    @Nonnull
    @Override
    public String getProperty(@Nonnull final String propertyName) {
        return resourceBundle.getString(propertyName);
    }
}
