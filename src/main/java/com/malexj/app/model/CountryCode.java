package com.malexj.app.model;

import com.malexj.app.model.base.BaseModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Table: COUNTRY_CODE
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * id        INTEGER,
 * country   VARCHAR(45) UNIQUE NOT NULL,
 * phoneCode VARCHAR(45) UNIQUE NOT NULL,
 * isoCodes  VARCHAR(45)        NOT NULL
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class CountryCode extends BaseModel {
    private String country;
    private String phoneCode;
    private String isoCodes;
}
