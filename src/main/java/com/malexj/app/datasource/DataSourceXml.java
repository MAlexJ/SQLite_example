package com.malexj.app.datasource;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Recordset;

public interface DataSourceXml {

    Connection connect();

    void close(Connection connection);

    Recordset getRows(Connection connection, String query);

}
