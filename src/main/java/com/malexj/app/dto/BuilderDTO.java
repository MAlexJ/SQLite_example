package com.malexj.app.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@Getter
@ToString
public class BuilderDTO
{
    // response
    private String message;
    boolean isError;

    // default
    private String html;

    // Category
    private Integer idCategory;
    private String nameCategory;
    private String descriptionCategory;
    private String htmlCategory;

    // SubCategory
    private Integer idSubCategory;
    private String nameSubCategory;
    private String descriptionSubCategory;
    private String htmlSubCategory;

    private List<BuilderDTO> subCategories;

    public static class BuilderDTOBuilder
    {
        BuilderDTOBuilder addSubCategory(BuilderDTO dto)
        {
            if (subCategories == null)
            {
                subCategories = new ArrayList<>();
            }
            subCategories.add(dto);
            return this;
        }
    }
}
