package com.malexj.app.repository.impl;

import com.malexj.app.dto.BuilderDTO;
import com.malexj.app.repository.SubCategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SubCategoryDaoImp implements SubCategoryDao
{
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SubCategoryDaoImp(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<BuilderDTO> getAll()
    {
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet("SELECT id, subCategoryName, description, html, categoryId FROM subCategoryTable");
        List<BuilderDTO> list = new ArrayList<>();
        while (sqlRowSet.next())
        {
            list.add(BuilderDTO.builder()
                    .id(sqlRowSet.getInt("id"))
                    .subCategoryName(sqlRowSet.getString("subCategoryName"))
                    .description(sqlRowSet.getString("description"))
                    .html(sqlRowSet.getString("html"))
                    .categoryId(sqlRowSet.getInt("categoryId"))
                    .build());
        }
        return list;
    }
}
