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
     * QUERY:
     */
    private final static String SELECT_SUB_CATEGORY_TABLE = "SELECT idSubCategory, nameSubCategory, descriptionSubCategory, htmlSubCategory, idCategory FROM subCategoryTable";
    private final static String SELECT_SUB_CATEGORY = "SELECT sub.idSubCategory, sub.nameSubCategory, sub.htmlSubCategory, cat.htmlCategory " +
            "FROM subCategoryTable AS sub " +
            "LEFT JOIN categoryTable AS cat ON sub.idCategory = cat.idCategory " +
            "WHERE cat.nameCategory = 'ddl'";

    @Autowired
    public SubCategoryDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public BuilderDTO getAll() {
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(SELECT_SUB_CATEGORY_TABLE);

        List<BuilderDTO> list = new ArrayList<>();
        String html = "<h1>HTML</h1>";

        while (sqlRowSet.next()) {
            list.add(BuilderDTO.builder()
                    .idSubCategory(sqlRowSet.getInt("idSubCategory"))
                    .nameSubCategory(sqlRowSet.getString("nameSubCategory"))
                    .descriptionSubCategory(sqlRowSet.getString("descriptionSubCategory"))
                    .htmlSubCategory(sqlRowSet.getString("htmlSubCategory"))
                    .idCategory(sqlRowSet.getInt("idCategory"))
                    .build());
        }

        return BuilderDTO.builder()
                .html(html)
                .subCategories(list)
                .build();
    }

    @Override
    public BuilderDTO getListSubCategoriesByCategoryName(String subDdl) {

        return null;
    }
}
