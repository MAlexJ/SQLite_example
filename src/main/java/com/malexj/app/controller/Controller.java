package com.malexj.app.controller;

import com.malexj.app.dao.UserDao;
import com.malexj.app.dao.impl.UserDaoImpl;
import com.malexj.app.datasource.DataSource;
import com.malexj.app.datasource.impl.DataSourceImpl;
import com.malexj.app.model.User;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.util.List;

@Slf4j
public class Controller {

	public static void main(String[] args) {

		DataSource ds = new DataSourceImpl();
		UserDao userDao = new UserDaoImpl();

		Connection connect = ds.connect();

		List<User> allUsers = userDao.findAllUsers(connect);
		log.debug(allUsers.toString());

		ds.close(connect);
	}

}