package com.malexj.app.model;

import com.malexj.app.model.base.BaseModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * TABLE: PHONE
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * id          INTEGER,
 * phoneNumber VARCHAR(20) NULL,
 * phoneCodeId INTEGER     NOT NULL,
 * userId      INTEGER     NOT NULL
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Phone extends BaseModel {
    private int userId;
    private int phoneCodeId;
    private String phoneNumber;
}
