package com.malexj.app.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@PropertySource("classpath:/DataSourceConfig.xml")
public class SqlTemplate
{
    private Environment env;

    @Autowired
    public void setEnvironment(Environment environment)
    {
        this.env = environment;
    }

    /**
     * SQL QUERIES:
     */
    public String getListCategoriesBySubCategoryNameSql()
    {
        return getProperty("getListCategoriesBySubCategoryName");
    }

    public String getHtmlSubCategoryBySubCategoryIdSql()
    {
        return getProperty("getHtmlSubCategoryBySubCategoryId");
    }


    private String getProperty(String sqlQuery)
    {
        return Objects.requireNonNull(env.getProperty(sqlQuery), "Not found sql query: " + sqlQuery);
    }

}
