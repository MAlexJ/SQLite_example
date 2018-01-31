package com.malexj.app.controller;

import com.codoid.products.fillo.Recordset;
import com.malexj.app.dao.CategoryDefinitionDao;
import com.malexj.app.dao.UserDao;
import com.malexj.app.dao.impl.CategoryDefinitionDaoImpl;
import com.malexj.app.dao.impl.UserDaoImpl;
import com.malexj.app.datasource.DataSource;
import com.malexj.app.datasource.DataSourceXml;
import com.malexj.app.datasource.impl.DataSourceImpl;
import com.malexj.app.datasource.impl.DataSourceXmlImpl;
import com.malexj.app.exception.AppException;
import com.malexj.app.model.User;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

@Slf4j
public class Controller {

    public static void main(String[] args) throws SQLException {
        DataSource ds = new DataSourceImpl();
        Connection connect = ds.connect();
        CategoryDefinitionDao dao = new CategoryDefinitionDaoImpl();

//        fillCategory(connect, dao);
//        ResultSet select = dao.select(connect, "SELECT * FROM categoryDefinition");
//        while (select.next()) {
//            System.out.println(select.getInt("id") + "  " + select.getString("category"));
//        }

//        ResultSet select = dao.select(connect, "select category from" +
//                " (  select distinct category from categoryDefinition  WHERE category != '-' order by category ) ");
//        while (select.next()) {
//            System.out.println(select.getInt("category"));
//        }

        System.out.println("```````````````````````````````````````````");

        ResultSet select = dao.select(connect, "select distinct * from categoryDefinition ");
        while (select.next()) {
            ResultSetMetaData metaData = select.getMetaData();
            int columnCount = metaData.getColumnCount();
            IntStream.range(1, columnCount + 1).forEach(item ->
                    {
                        try {
                            System.out.print( metaData.getTableName(item) + "  >>> ");
                            System.out.print(metaData.getColumnName(item) + ", type=");
                            System.out.print(JDBCType.valueOf(metaData.getColumnType(item)) + ": ");
                            System.out.print(select.getObject(item) + " ");
                        } catch (SQLException e) {
                            throw new AppException(e.getMessage());
                        }
                    }
            );
            System.out.println();
        }

        ds.close(connect);
    }

    private static void fillCategory(Connection connect, CategoryDefinitionDao dao) {


        DataSourceXml xml = new DataSourceXmlImpl();
        Recordset rows = xml.getRows(xml.connect(), "SELECT  MapScale FROM CategoryBrandPropertyDefinition");
        int id = 1;
        try {
            while (rows.next()) {
                if (rows.getField("MapScale").length() < 50) {
                    dao.createCategory(connect, id++, rows.getField("MapScale"));
                }
            }
        } catch (Exception ex) {
            String message = ex.getMessage();
            log.error(message);
            throw new AppException(message);
        }
        xml.close(xml.connect());
    }


    private static void getUsers(Connection connect) {
        UserDao userDao = new UserDaoImpl();
        List<User> allUsers = userDao.findAllUsers(connect);
        log.debug(allUsers.toString());

        User user = new User();
        user.setFullName("Max");
        user.setPassword(IntStream.range(100, 4000).toString());
        user.setEmail("email@" + UUID.randomUUID() + ".com");
        userDao.createUser(connect, user);

        allUsers = userDao.findAllUsers(connect);
        log.debug(allUsers.toString());
        log.debug("SIZE: " + allUsers.size());
    }
}
