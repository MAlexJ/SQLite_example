-- -----------------------------------------------------
-- Table userTable
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS userTable (
  id          INTEGER,
  firstName   VARCHAR(45)        NULL,
  lastName    VARCHAR(45)        NULL,
  dateOfBirth DATE               NULL,
  email       VARCHAR(45) UNIQUE NOT NULL,
  password    VARCHAR(45)        NOT NULL,
  avatar      BLOB               NULL,
  PRIMARY KEY (id)
);

-- -----------------------------------------------------
-- Table roleTable
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS roleTable (
  id   INTEGER,
  role VARCHAR(45) NOT NULL,
  PRIMARY KEY (id)
);

-- -----------------------------------------------------
-- Table userRoleTable
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS userRoleTable (
  userId INTEGER NOT NULL,
  roleId INTEGER NOT NULL,
  PRIMARY KEY (userId, roleId),
  CONSTRAINT fk_userTable_roleTable_userId FOREIGN KEY (userId)
  REFERENCES userTable (id),
  CONSTRAINT fk_roleTable_userTable_userId FOREIGN KEY (roleId)
  REFERENCES roleTable (id)
);

-- -----------------------------------------------------
-- Table countryCodeTable
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS countryCodeTable (
  id        INTEGER,
  country   VARCHAR(45) UNIQUE NOT NULL,
  phoneCode VARCHAR(45) UNIQUE NOT NULL,
  isoCodes  VARCHAR(45)        NOT NULL,
  PRIMARY KEY (id)
);

-- -----------------------------------------------------
-- Table phoneTable
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS phoneTable (
  id          INTEGER,
  phoneNumber VARCHAR(20) NULL,
  phoneCodeId INTEGER     NOT NULL,
  userId      INTEGER     NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_userTable_phoneTable FOREIGN KEY (userId)
  REFERENCES userTable (id),
  CONSTRAINT fk_countryCodeTable_phoneTable FOREIGN KEY (phoneCodeId)
  REFERENCES countryCodeTable (id)
);

-- -----------------------------------------------------
-- Table addressTable
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS addressTable (
  id        INTEGER,
  street    VARCHAR(45) NULL,
  apartment VARCHAR(45) NULL,
  userId    INTEGER     NOT NULL,
  countryId INTEGER     NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_userTable_addressTable FOREIGN KEY (userId)
  REFERENCES userTable (id),
  CONSTRAINT fk_addressTable_phoneTable FOREIGN KEY (countryId)
  REFERENCES countryCodeTable (id)
);