package com.malexj.app.config;

import com.malexj.app.service.IPropertiesReaderApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = {"com.malexj"})
public class ConsoleDataSourceConfig
{
    private final IPropertiesReaderApp reader;

    @Autowired
    public ConsoleDataSourceConfig(IPropertiesReaderApp propertiesReaderApp)
    {
        this.reader = propertiesReaderApp;
    }

    @Bean(name = "dataSourceConsole")
    public DataSource jdbcDataSource()
    {
        SingleConnectionDataSource ds = new SingleConnectionDataSource();
        ds.setSuppressClose(true);
        ds.setDriverClassName(reader.getProperty("console.driver.class.name"));
        ds.setUrl(reader.getProperty("console.url.database"));
        return ds;
    }
}
