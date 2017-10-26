package com.malexj.app.datasource.impl;

import com.malexj.app.datasource.DataSource;
import com.malexj.app.exception.AppException;
import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.assertNotNull;

public class DataSourceImplTest {

	@Test
	public void testConnect() {
		DataSource ds = new DataSourceImpl();
		Connection connect = ds.connect();
		assertNotNull(connect);
	}

	@Test
	public void testCloseConnection() {
		// open
		DataSource ds = new DataSourceImpl();
		Connection connect = ds.connect();
		assertNotNull(connect);
		// close
		ds.close(connect);
	}

	@Test(expected = AppException.class)
	public void testCloseConnectionException() {
		DataSource ds = new DataSourceImpl();
		ds.close(null);
	}

}