package com.malexj.app.controller;

import com.malexj.app.dao.UserDao;
import com.malexj.app.dao.impl.UserDaoImpl;
import com.malexj.app.datasource.DataSource;
import com.malexj.app.datasource.impl.DataSourceImpl;
import com.malexj.app.model.User;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

@Slf4j
public class Controller {

	public static void main(String[] args) {

		DataSource ds = new DataSourceImpl();
		UserDao userDao = new UserDaoImpl();

		Connection connect = ds.connect();

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

		ds.close(connect);
	}

}