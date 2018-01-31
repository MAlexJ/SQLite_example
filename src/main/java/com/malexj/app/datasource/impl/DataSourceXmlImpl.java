package com.malexj.app.datasource.impl;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.malexj.app.datasource.DataSourceXml;
import com.malexj.app.exception.AppException;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
public class DataSourceXmlImpl implements DataSourceXml {

    public Connection connect() {
        try {
            return new Fillo().getConnection(getPathToFile());
        } catch (FilloException ex) {
            String message = ex.getMessage();
            log.error(message);
            throw new AppException(message);
        }
    }

    public void close(@NonNull Connection connection) {
        connection.close();
    }

    @Override
    public Recordset getRows(Connection connection, String query) {
        try {
            return connection.executeQuery(query);
        } catch (FilloException ex) {
            String message = ex.getMessage();
            log.error(message);
            throw new AppException(message);
        }
    }

    private String getPathToFile() {
        ClassLoader loader = DataSourceXmlImpl.class.getClassLoader();
        return Objects.requireNonNull(loader.getResource("CategoryDefinition.xlsx")).getPath();
    }
}
