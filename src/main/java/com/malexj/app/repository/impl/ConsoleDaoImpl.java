package com.malexj.app.repository.impl;

import com.malexj.app.dto.BuilderDTO;
import com.malexj.app.exception.AppException;
import com.malexj.app.repository.ConsoleDao;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.malexj.app.constant.Constant.SUCCESS_MESSAGE;

@Slf4j
@Repository
public class ConsoleDaoImpl implements ConsoleDao
{
    private static final String ERROR_QUERY = "Error execute query: %s, Message: %s";

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
            log.error(String.format(ERROR_QUERY, query, ex.getMessage()));
            return BuilderDTO.builder()
                    .isError(true)
                    .message(ex.getMessage())
                    .build();
        }
    }

    @Override
    public BuilderDTO executeUpdate(String query)
    {
        BuilderDTO.BuilderDTOBuilder builder = BuilderDTO.builder().message(SUCCESS_MESSAGE);
        try(Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement())
        {
            statement.execute(query);
        } catch (SQLException ex)
        {
            log.error(String.format(ERROR_QUERY, query, ex.getMessage()));
            builder.message(ex.getMessage()).isError(true);
        }
        return builder.build();
    }

    private BuilderDTO getResultFromSelectQuery(ResultSet resultSet) throws SQLException
    {
        // #1 get MetaData from ResultSet
        ResultSetMetaData metaData = resultSet.getMetaData();
        LinkedHashSet<ResultMetaData> resultMetaDataSet = IntStream.rangeClosed(1, metaData.getColumnCount())
                .boxed()
                .map(countNumber -> getColumnTypeName(countNumber, metaData))
                .collect(Collectors.toCollection(LinkedHashSet::new));

        // #2 get columnNames from MetaData
        LinkedHashSet<String> columnNameSet = resultMetaDataSet.stream()
                .map(ResultMetaData::getColumnName)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        // #3 get data from ResultSet by columnNames
        List<List<Object>> resultSetRow = new ArrayList<>();
        while (resultSet.next())
        {
            List<Object> rows = new ArrayList<>();
            for (ResultMetaData resultMetaData : resultMetaDataSet)
            {
                rows.add(resultSet.getObject(resultMetaData.getId()));
            }
            resultSetRow.add(rows);
        }

        return BuilderDTO.builder()
                .resultColumns(columnNameSet)
                .resultRows(resultSetRow)
                .build();
    }

    private ResultMetaData getColumnTypeName(int countNumber, ResultSetMetaData metaData)
    {
        try
        {
            return new ResultMetaData(countNumber, metaData.getColumnName(countNumber));
        } catch (SQLException ex)
        {
            log.error("Error parsing ResultSetMetaData from ResultSet.", ex);
            throw new AppException(ex.getMessage(), "countNumber: ", countNumber);
        }
    }

    @Getter
    @AllArgsConstructor
    @EqualsAndHashCode
    private static class ResultMetaData
    {
        private int id;
        private String columnName;
    }
}
