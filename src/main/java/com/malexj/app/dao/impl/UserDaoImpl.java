package com.malexj.app.dao.impl;

import com.malexj.app.dao.UserDao;
import com.malexj.app.exception.AppException;
import com.malexj.app.model.User;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class UserDaoImpl implements UserDao {

    /**
     * SQL
     */
    private final static String SQL_FIND_ALL_USERS = "SELECT userId, fullName, email, password FROM users";
    private final static String SQL_INSERT_USER = "INSERT INTO users (fullName,email, password) VALUES (?,?,?)";

    @Override
    public List<User> findAllUsers(Connection connection) {

        try (PreparedStatement statement = connection.prepareStatement(SQL_FIND_ALL_USERS)) {

            List<User> users = new ArrayList<>();

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setFullName(rs.getString("fullName"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                users.add(user);
            }

            return users;

        } catch (SQLException ex) {
            String message = ex.getMessage();
            log.error(message);
            throw new AppException("Error find user: %s", message);
        }
    }

    @Override
    public void createUser(Connection connection, User user) {

        try (PreparedStatement statement = connection.prepareStatement(SQL_INSERT_USER)) {

            statement.setString(1, user.getFullName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());

            if (statement.executeUpdate() < 1) {
                throw new AppException("Error insert operation, user: %s", user);
            }

        } catch (SQLException ex) {
            String message = ex.getMessage();
            log.error(message);
            throw new AppException("Error create a new user: %s, error message: %s", user, message);
        }

    }
}
