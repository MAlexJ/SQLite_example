package com.malexj.app.controller;

import com.codoid.products.fillo.Recordset;
import com.malexj.app.dao.CategoryDefinitionDao;
import com.malexj.app.dao.impl.CategoryDefinitionDaoImpl;
import com.malexj.app.datasource.DataSource;
import com.malexj.app.datasource.DataSourceXml;
import com.malexj.app.datasource.impl.DataSourceImpl;
import com.malexj.app.datasource.impl.DataSourceXmlImpl;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@Slf4j
public class Controller {

    public static void main(String[] args) throws SQLException {
        DataSource ds = new DataSourceImpl();
        Connection connect = ds.connect();
        CategoryDefinitionDao dao = new CategoryDefinitionDaoImpl();

        createTable();

        fillCategory(connect, dao);

        dao.select(connect, "select distinct * from categoryDefinition ");

        ds.close(connect);
    }

    private static void createTable() {
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:db/db_app.db");
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS categoryDefinition (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,category TEXT NOT NULL);";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Table created successfully");
    }

    private static void fillCategory(Connection connect, CategoryDefinitionDao dao) {
        DataSourceXml xml = new DataSourceXmlImpl();
        Recordset rows = xml.getRows(xml.connect(), "SELECT  MapScale FROM CategoryBrandPropertyDefinition");
        try {
            while (rows.next()) {
                if (rows.getField("MapScale").length() < 50) {
                    dao.createCategory(connect, rows.getField("MapScale"));
                }
            }
        } catch (Exception ex) {
            String message = ex.getMessage();
            log.error(message);
            ex.printStackTrace();
        }
        xml.close(xml.connect());
    }
}