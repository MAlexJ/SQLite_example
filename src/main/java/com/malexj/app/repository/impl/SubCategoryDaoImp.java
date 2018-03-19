package com.malexj.app.repository.impl;

import com.malexj.app.dto.BuilderDTO;
import com.malexj.app.repository.SubCategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

@Repository
public class SubCategoryDaoImp implements SubCategoryDao
{
    /**
     * DataSource
     */
    private final JdbcTemplate jdbcTemplate;

    /**
     * QUERY:
     */
    private final static String SELECT_SUB_CATEGORY = "SELECT sub.idSubCategory, sub.nameSubCategory, sub.htmlSubCategory " +
            "FROM subCategoryTable AS sub " +
            "LEFT JOIN categoryTable AS cat ON sub.idCategory = cat.idCategory " +
            "WHERE cat.nameCategory = ? AND sub.idSubCategory = ?";

    @Autowired
    public SubCategoryDaoImp(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public BuilderDTO getListSubCategoriesByCategoryName(String subDdl, Integer idCategory)
    {
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(SELECT_SUB_CATEGORY, subDdl, idCategory);
        sqlRowSet.next();
        return BuilderDTO.builder()
                .idSubCategory(sqlRowSet.getInt("idSubCategory"))
                .nameSubCategory(sqlRowSet.getString("nameSubCategory"))
                .htmlSubCategory(sqlRowSet.getString("htmlSubCategory"))
                .build();
    }
}
