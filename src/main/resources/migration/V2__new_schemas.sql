-- -----------------------------------------------------
-- Table categoryTable
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS categoryTable (
  id           INTEGER,
  categoryName VARCHAR(45) NOT NULL,
  description  VARCHAR(45) NULL,
  PRIMARY KEY (id)
);

-- -----------------------------------------------------
-- Table subCategoryTable
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS subCategoryTable (
  id              INTEGER,
  subCategoryName VARCHAR(45) NOT NULL,
  description     VARCHAR(45) NULL,
  html            TEXT        NULL,
  categoryId      INTEGER,
  PRIMARY KEY (id),
  CONSTRAINT fk_categoryTable_subCategoryTable_categoryId FOREIGN KEY (categoryId)
  REFERENCES categoryTable (id)
);

