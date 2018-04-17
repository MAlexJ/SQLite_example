package com.malexj.app.repository.impl;

import com.malexj.app.dto.BuilderDTO;
import com.malexj.app.repository.ConsoleDao;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

@Repository
public class ConsoleDaoImpl implements ConsoleDao
{
    /**
     * DataSource
     */
    private final DataSource dataSource;

    @Autowired
    public ConsoleDaoImpl(@Qualifier("dataSourceConsole") DataSource dataSource)
    {
        this.dataSource = dataSource;
    }

    @Override
    public BuilderDTO executeSelect(String query)
    {
        try (Connection connection = dataSource.getConnection();
             ResultSet resultSet = connection.createStatement().executeQuery(query))
        {
            return getResultFromSelectQuery(resultSet);
        } catch (SQLException ex)
        {
            return BuilderDTO.builder()
                    .isError(true)
                    .message(ex.getMessage())
                    .build();
        }
    }

    private BuilderDTO getResultFromSelectQuery(ResultSet resultSet) throws SQLException
    {
        ResultSetMetaData metaData = resultSet.getMetaData();
        Set<ResultObj> meta = new HashSet<>();
        for (int i = 1; i <= metaData.getColumnCount(); i++)
        {
            String columnName = metaData.getColumnName(i);
            String columnType = metaData.getColumnTypeName(i);
            ResultObj resultObj = new ResultObj(i, columnName, columnType);
            meta.add(resultObj);
        }
        while (resultSet.next())
        {
            for (ResultObj resultObj : meta)
            {
                System.out.print("Result: " + resultSet.getObject(resultObj.getId()));
            }
            System.out.println();
        }
        return null;
    }

    @Getter
    @AllArgsConstructor
    @EqualsAndHashCode
    private static class ResultObj
    {
        private int id;
        private String columnName;
        private String columnType;
    }

    @Override
    public BuilderDTO executeUpdate(String query)
    {
        return null;
    }
}
