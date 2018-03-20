-- -----------------------------------------------------
-- Table categoryTable
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS categoryTable (
  idCategory          INTEGER,
  nameCategory        VARCHAR(45) NOT NULL,
  descriptionCategory VARCHAR(45) NULL,
  htmlCategory        TEXT        NULL,
  PRIMARY KEY (idCategory)
);

-- -----------------------------------------------------
-- Table subCategoryTable
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS subCategoryTable (
  idSubCategory          INTEGER,
  nameSubCategory        VARCHAR(45) NOT NULL,
  htmlSubCategory        TEXT        NULL,
  idCategory             INTEGER,
  PRIMARY KEY (idSubCategory),
  CONSTRAINT fk_categoryTable_subCategoryTable_categoryId FOREIGN KEY (idCategory)
  REFERENCES categoryTable (idCategory)
);

