package com.malexj.app.dao;

import java.sql.Connection;
import java.sql.ResultSet;

public interface CategoryDefinitionDao {

    void createCategory(Connection connection, String category);

    void select(Connection connection, String query);
}
