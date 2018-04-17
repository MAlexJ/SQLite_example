package com.malexj.app.config;

import com.malexj.app.service.IPropertiesReaderApp;
import org.springframework.beans.factory.annotation.Autowired;
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
    private final IPropertiesReaderApp reader;

    @Autowired
    public DataSourceConfig(IPropertiesReaderApp propertiesReaderApp)
    {
        this.reader = propertiesReaderApp;
    }

    @Bean
    public JdbcTemplate getJdbcTemplate(DataSource dataSource)
    {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public DataSource jdbcDataSource()
    {
        SingleConnectionDataSource ds = new SingleConnectionDataSource();
        ds.setDriverClassName(reader.getProperty("app.driver.class.name"));
        ds.setUrl(reader.getProperty("app.url.database"));
        return ds;
    }
}
