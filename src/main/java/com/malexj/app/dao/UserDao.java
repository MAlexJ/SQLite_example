package com.malexj.app.dao;

import com.malexj.app.model.User;

import java.sql.Connection;
import java.util.List;

public interface UserDao {

	List<User> findAllUsers(Connection connection);
}
