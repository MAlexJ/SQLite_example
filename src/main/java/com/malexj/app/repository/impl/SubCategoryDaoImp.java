package com.malexj.app.repository.impl;

import com.malexj.app.dto.BuilderDTO;
import com.malexj.app.repository.SqlTemplate;
import com.malexj.app.repository.SubCategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SubCategoryDaoImp implements SubCategoryDao
{
    /**
     * DataSource
     */
    private final SqlTemplate sqlTemplate;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SubCategoryDaoImp(JdbcTemplate jdbc, SqlTemplate sql)
    {
        this.jdbcTemplate = jdbc;
        this.sqlTemplate = sql;
    }

    @Override
    public BuilderDTO getListCategoriesByCategoryName(String subCategoryName)
    {
        String sql = sqlTemplate.getListCategoriesBySubCategoryNameSql();
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(sql, subCategoryName);
        List<BuilderDTO> subCategories = new ArrayList<>();
        while (sqlRowSet.next())
        {
            subCategories
                    .add(BuilderDTO.builder()
                            .idSubCategory(sqlRowSet.getInt("idSubCategory"))
                            .nameSubCategory(sqlRowSet.getString("nameSubCategory"))
                            .htmlCategory(sqlRowSet.getString("htmlCategory"))
                            .build());
        }
        return BuilderDTO
                .builder()
                .subCategories(subCategories)
                // todo: WTF find first!!!!!!
                .html(subCategories.stream().findFirst().orElse(BuilderDTO.builder().htmlCategory("<h1>Error page</h1>").build()).getHtmlCategory())
                .build();
    }

    @Override
    public BuilderDTO getHtmlSubCategoriesByIdSubCategory(int idSubCategory)
    {
        String sql = sqlTemplate.getHtmlSubCategoryBySubCategoryIdSql();
        return jdbcTemplate.query(sql, getHtmlSubCategory(), idSubCategory);
    }

    private ResultSetExtractor<BuilderDTO> getHtmlSubCategory()
    {
        return rs -> BuilderDTO.builder()
                .html(rs.getString("htmlSubCategory"))
                .build();
    }
}
