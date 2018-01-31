package com.malexj.app.dao.impl;

import com.malexj.app.dao.CategoryDefinitionDao;
import com.malexj.app.exception.AppException;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;
import java.util.stream.IntStream;

@Slf4j
public class CategoryDefinitionDaoImpl implements CategoryDefinitionDao {

    /**
     * SQL query
     */
    private final static String SQL_INSERT_CATEGORY = "INSERT INTO categoryDefinition (category) VALUES (?)";

    @Override
    public void createCategory(Connection connection, String category) {
        try (PreparedStatement statement = connection.prepareStatement(SQL_INSERT_CATEGORY)) {
            statement.setString(1, category);
            if (statement.executeUpdate() < 1) {
                throw new AppException("Error inserting the table 'categoryDefinition'");
            }
        } catch (SQLException ex) {
            throw new AppException(logException(ex.getMessage()));
        }
    }

    @Override
    public void select(Connection connection, String query) {
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet select = statement.executeQuery()) {

            while (select.next()) {
                ResultSetMetaData metaData = select.getMetaData();
                int columnCount = metaData.getColumnCount();
                IntStream.range(1, columnCount + 1).forEach(item ->
                        {
                            try {
                                System.out.print(metaData.getTableName(item) + "  >>> ");
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

        } catch (SQLException ex) {
            throw new AppException(logException(ex.getMessage()));
        }
    }

    private String logException(String message) {
        log.error(message);
        return message;
    }
}
