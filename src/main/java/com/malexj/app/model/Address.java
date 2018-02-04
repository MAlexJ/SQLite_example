package com.malexj.app.model;

import com.malexj.app.model.base.BaseModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Table: ADDRESS
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * id         INTEGER,
 * street     VARCHAR(45) NULL,
 * apartment VARCHAR(45) NULL,
 * userId     INTEGER     NOT NULL,
 * countryId  INTEGER     NOT NULL
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Address extends BaseModel {
    private String street;
    private String apartment;
    private int userId;
    private int countryId;
}
