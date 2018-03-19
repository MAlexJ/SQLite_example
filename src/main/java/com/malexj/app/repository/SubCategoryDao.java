package com.malexj.app.repository;

import com.malexj.app.dto.BuilderDTO;

public interface SubCategoryDao {
    BuilderDTO getListSubCategoriesByCategoryName(String subDdl);
}
