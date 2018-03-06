package com.malexj.app.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class BuilderDTO {
    private Integer id;
    private Integer categoryId;
    private String categoryName;
    private String description;
    private String subCategoryName;
    private String html;
}
