package com.malexj.app.dao.impl;

import com.malexj.app.dao.UserDao;
import com.malexj.app.datasource.DataSource;
import com.malexj.app.datasource.impl.DataSourceImpl;
import com.malexj.app.model.User;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;

import static org.junit.Assert.assertNotNull;


public class UserDaoImplTest {

	private static Connection connect;
	private static DataSource ds;

	@BeforeClass
	public static void before() {
		ds = new DataSourceImpl();
		connect = ds.connect();
		assertNotNull(connect);
	}

	@AfterClass
	public static void after() {
		ds.close(connect);
	}

	@Test
	public void testFindAllUsers() {
		UserDao dao = new UserDaoImpl();
		List<User> allUsers = dao.findAllUsers(connect);
		assertNotNull(allUsers);
		System.out.println(allUsers);
	}

}