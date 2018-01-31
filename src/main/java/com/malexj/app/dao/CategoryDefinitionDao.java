package com.malexj.app.dao;

import java.sql.Connection;
import java.sql.ResultSet;

public interface CategoryDefinitionDao {

    void createCategory(Connection connection, int id, String category);

    ResultSet select(Connection connection, String query);
}
