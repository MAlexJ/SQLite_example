package com.malexj.app.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuilderDTOTest
{

    @Test
    void test()
    {
        BuilderDTO dto = BuilderDTO.builder().idCategory(1).build();
        assertEquals(1, dto.getIdCategory().intValue());
        assertNull(dto.getIdSubCategory());
        assertNull(null, dto.getNameCategory());
        assertNull(null, dto.getDescriptionCategory());
        assertNull(null, dto.getHtmlCategory());

        dto = BuilderDTO.builder().idCategory(9).htmlCategory("<input>").build();
        assertEquals("<input>", dto.getHtmlCategory());
        assertEquals(9, dto.getIdCategory().intValue());
    }

    @Test
    void testPage()
    {
        BuilderDTO subCategoryFirst = BuilderDTO.builder()
                .idSubCategory(1)
                .nameSubCategory("Name_1")
                .descriptionSubCategory("Desc_1")
                .htmlSubCategory("Html_1")
                .build();

        BuilderDTO subCategorySecond = BuilderDTO.builder()
                .idSubCategory(2)
                .nameSubCategory("Name_2")
                .descriptionSubCategory("Desc_2")
                .htmlSubCategory("Html_2")
                .build();

        String html = "<h2>HTML!</h2>";

        BuilderDTO page = BuilderDTO.builder()
                .html(html)
                .addSubCategory(subCategoryFirst)
                .addSubCategory(subCategorySecond)
                .build();

        // positive
        assertEquals(html, page.getHtml());
        assertTrue(page.getSubCategories().contains(subCategoryFirst));
        assertTrue(page.getSubCategories().contains(subCategorySecond));

        // negative
        assertFalse(page.getSubCategories().contains(BuilderDTO.builder()
                .idSubCategory(3)
                .nameSubCategory("Name_3")
                .descriptionSubCategory("Desc_2")
                .htmlSubCategory("Html_2")
                .build()));
    }
}