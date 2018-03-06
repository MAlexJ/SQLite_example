package com.malexj.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = {"com.malexj"})
public class DataSourceConfig
{
    @Bean
    public JdbcTemplate getJdbcTemplate()
    {
        return new JdbcTemplate(jdbcDataSource());
    }

    @Bean
    public DataSource jdbcDataSource()
    {
        SingleConnectionDataSource ds = new SingleConnectionDataSource();
        ds.setDriverClassName("org.sqlite.JDBC");
        ds.setUrl("jdbc:sqlite::resource:db/db_app.db");
        return ds;
    }
}