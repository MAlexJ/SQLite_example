package com.malexj.app.model;

import com.malexj.app.model.base.BaseModel;
import lombok.*;

import java.time.LocalDate;

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * TABLE: USER
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * id          INTEGER,
 * firstName   VARCHAR(45)        NULL,
 * lastName    VARCHAR(45)        NULL,
 * dateOfBirth DATE               NULL,
 * email       VARCHAR(45) UNIQUE NOT NULL,
 * password    VARCHAR(45)        NOT NULL,
 * avatar      BLOB               NULL
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString(exclude = {"avatar", "dateOfBirth", "password"})
public class User extends BaseModel {
    private String fullName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String email;
    private String password;
    private byte[] avatar;
}