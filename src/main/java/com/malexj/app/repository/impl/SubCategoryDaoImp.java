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
public class SubCategoryDaoImp implements SubCategoryDao {
    /**
     * DataSource
     */
    private final JdbcTemplate jdbcTemplate;

    /**
     * SQL QUERIES:
     */
    private final static String SELECT_LIST_CATEGORIES_BY_SUB_CATEGORY_NAME = "SELECT sub.idSubCategory, sub.nameSubCategory, cat.htmlCategory " +
            "FROM subCategoryTable AS sub " +
            "LEFT JOIN categoryTable AS cat ON sub.idCategory = cat.idCategory " +
            "WHERE cat.nameCategory = ?";

    private final static String SELECT_HTML_SUB_CATEGORY_BY_ID_SUB_CATEGORY = "SELECT htmlSubCategory FROM subCategoryTable WHERE idSubCategory = ?";

    @Autowired
    public SubCategoryDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public BuilderDTO getListCategoriesByCategoryName(String subCategoryName) {
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(SELECT_LIST_CATEGORIES_BY_SUB_CATEGORY_NAME, subCategoryName);
        List<BuilderDTO> subCategories = new ArrayList<>();
        while (sqlRowSet.next()) {
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
                .html(subCategories.stream().findFirst().orElse(BuilderDTO.builder().htmlCategory("<h1>Error page</h1>").build()).getHtmlCategory())
                .build();
    }

    @Override
    public BuilderDTO getHtmlSubCategoriesByIdSubCategory(int idSubCategory) {
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(SELECT_HTML_SUB_CATEGORY_BY_ID_SUB_CATEGORY, idSubCategory);
        sqlRowSet.next();
        return BuilderDTO.builder()
                .htmlSubCategory(sqlRowSet.getString("htmlSubCategory"))
                .build();
    }
}
