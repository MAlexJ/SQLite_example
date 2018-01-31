package com.malexj.app.dao.impl;

import com.malexj.app.dao.CategoryDefinitionDao;
import com.malexj.app.exception.AppException;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Slf4j
public class CategoryDefinitionDaoImpl implements CategoryDefinitionDao {

    private final static String SQL_INSERT_CATEGORY = "INSERT INTO categoryDefinition (id, category) VALUES (?,?)";

    @Override
    public void createCategory(Connection connection, int id, String category) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT_CATEGORY);
            statement.setInt(1, id);
            statement.setString(2, category);

            if (statement.executeUpdate() < 1) {
                throw new AppException("Error inserting the table 'users'");
            }
        } catch (SQLException ex) {
            String message = ex.getMessage();
            log.error(message);
            throw new AppException(message);
        }
    }

    public ResultSet select(Connection connection, String query) {
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            return statement.executeQuery();
        } catch (SQLException ex) {
            String message = ex.getMessage();
            log.error(message);
            throw new AppException(message);
        }
    }
}
