package com.malexj.app.repository.impl;

import com.malexj.app.AbstractBaseTest;
import com.malexj.app.config.TestDataSourceConfig;
import com.malexj.app.dto.BuilderDTO;
import com.malexj.app.repository.SubCategoryDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.*;


@ContextConfiguration(classes = TestDataSourceConfig.class)
class SubCategoryDaoImpTest extends AbstractBaseTest
{

    @Autowired
    private SubCategoryDao subCategoryDao;

    @Test
    void testListCategoriesByCategoryName()
    {
        BuilderDTO category = subCategoryDao.getListCategoriesByCategoryName("ddl");
        assertNotNull(category);
        assertFalse(category.getSubCategories().isEmpty());
    }

    @Test
    void testHtmlSubCategoriesByIdSubCategory()
    {
        BuilderDTO htmlSubCategory = subCategoryDao.getHtmlSubCategoriesByIdSubCategory(1);
        assertNotNull(htmlSubCategory);
        assertFalse(htmlSubCategory.getHtml().isEmpty());
    }

}