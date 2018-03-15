package com.malexj.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PageDTO
{
    private List<SubCategoryDTO> subCategories;
    private String html;
}
