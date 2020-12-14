package com.malexj.app.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
@Getter
@ToString
public class BuilderDTO
{
    // response
    private final String message;
    boolean isError;

    // default
    private final String html;

    // Category
    private final Integer idCategory;
    private final String nameCategory;
    private final String descriptionCategory;
    private final String htmlCategory;

    // SubCategory
    private final Integer idSubCategory;
    private final String nameSubCategory;
    private final String descriptionSubCategory;
    private final String htmlSubCategory;

    private final List<BuilderDTO> subCategories;

    // RowSet
    private final Set<String> resultColumns;
    private final List<List<Object>> resultRows;

    public static class BuilderDTOBuilder
    {
        BuilderDTOBuilder addSubCategory(BuilderDTO dto)
        {
            if (Objects.isNull(subCategories))
            {
                subCategories = new ArrayList<>();
            }
            subCategories.add(dto);
            return this;
        }
    }
}
