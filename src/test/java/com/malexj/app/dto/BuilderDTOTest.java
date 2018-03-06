package com.malexj.app.dto;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BuilderDTOTest {

    @Test
    public void test() {
        BuilderDTO dto = BuilderDTO.builder().id(1).build();
        assertEquals(1, dto.getId().intValue());
        assertEquals(null, dto.getCategoryId());
        assertEquals(null, dto.getCategoryName());
        assertEquals(null, dto.getDescription());
        assertEquals(null, dto.getHtml());

        dto = BuilderDTO.builder().categoryId(9).html("<input>").build();
        assertEquals("<input>", dto.getHtml());
        assertEquals(9, dto.getCategoryId().intValue());
    }
}