package com.malexj.app.datasource;

import java.sql.Connection;

public interface DataSource {

	Connection connect();

	void close(Connection connection);

}
