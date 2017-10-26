package com.malexj.app.datasource.impl;

import com.malexj.app.datasource.DataSource;
import com.malexj.app.exception.AppException;
import lombok.extern.slf4j.Slf4j;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;

@Slf4j
public class DataSourceImpl implements DataSource {

	/**
	 * URL to DB.
	 */
	private static final String URL = "jdbc:sqlite:";

	/**
	 * Name of DataBase
	 */
	private static final String NAME_DB = "product_db.db";

	@Override
	public Connection connect() {

		try {

			ClassLoader classLoader = getClass().getClassLoader();
			URL resource = classLoader.getResource(NAME_DB);

			Optional<URL> urlDB = Optional.ofNullable(resource);
			if (!urlDB.isPresent()) {
				throw new AppException("The Database is not found!");
			}

			Connection connection = DriverManager.getConnection(URL + urlDB.get().getPath());
			log.debug("Connection to SQLite has been established.");

			return connection;

		} catch (SQLException ex) {
			String message = ex.getMessage();
			log.error(message);
			throw new AppException(message);
		}
	}

	@Override
	public void close(Connection connection) {

		if (connection != null) {
			try {

				connection.close();
				log.debug("Connection to SQLite is closed.");

			} catch (SQLException e) {
				String message = e.getMessage();
				log.error(message);
				throw new AppException(message);
			}

		} else {

			String message = "No connection to DB!";
			log.error(message);
			throw new AppException(message);
		}
	}

}