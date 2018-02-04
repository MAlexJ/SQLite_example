package com.malexj.app.model;

import com.malexj.app.enums.UserRole;
import com.malexj.app.model.base.BaseModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~
 * TABLE: ROLE
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~
 * id   INTEGER,
 * role VARCHAR(45) NOT NULL
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Role extends BaseModel {
    private UserRole role;
}
