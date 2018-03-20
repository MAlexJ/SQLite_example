package com.malexj.app.repository;

import com.malexj.app.dto.BuilderDTO;

public interface SubCategoryDao {
    BuilderDTO getListCategoriesByCategoryName(String subCategoryName);

    BuilderDTO getHtmlSubCategoriesByIdSubCategory(int idSubCategory);
}
