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

	@Override
	public List<User> findAllUsers(Connection connection) {

		try (PreparedStatement statement = connection.prepareStatement(SQL_FIND_ALL_USERS)) {

			List<User> users = new ArrayList<>();

			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setUserId(rs.getInt("userId"));
				user.setFullName(rs.getString("fullName"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				users.add(user);
			}

			return users;

		} catch (SQLException ex) {
			String message = ex.getMessage();
			log.error(message);
			throw new AppException(message);
		}
	}
}
