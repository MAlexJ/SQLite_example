-- -----------------------------------------------------
-- Table categoryTable
-- -----------------------------------------------------
INSERT INTO categoryTable (idCategory, nameCategory, descriptionCategory, htmlCategory)
VALUES (1, 'dml', 'Data Manipulation Language', '<h3>Data Manipulation Language</h3><p>Text dml!</p>');

INSERT INTO categoryTable (idCategory, nameCategory, descriptionCategory, htmlCategory)
VALUES (2, 'ddl', 'Data Definition Language', '<h3>Data Definition Language</h3><p>Text ddl!</p>');

INSERT INTO categoryTable (idCategory, nameCategory, descriptionCategory, htmlCategory)
VALUES (3, 'dcl', 'Data Control Language', '<h3>Data Control Language</h3><p>Text dcl!</p>');

INSERT INTO categoryTable (idCategory, nameCategory, descriptionCategory, htmlCategory)
VALUES (4, 'tcl', 'Transaction Control Language', '<h3>Transaction Control Language</h3><p>Text tcl!</p>');

-- -----------------------------------------------------
-- Table subCategoryTable
-- -----------------------------------------------------
INSERT INTO subCategoryTable (idSubCategory, nameSubCategory, descriptionSubCategory, htmlSubCategory, idCategory)
VALUES (1, 'SELECT', NULL, NULL, 1);

INSERT INTO subCategoryTable (idSubCategory, nameSubCategory, descriptionSubCategory, htmlSubCategory, idCategory)
VALUES (2, 'INSERT', NULL, NULL, 1);

INSERT INTO subCategoryTable (idSubCategory, nameSubCategory, descriptionSubCategory, htmlSubCategory, idCategory)
VALUES (3, 'UPDATE', NULL, NULL, 1);


INSERT INTO subCategoryTable (idSubCategory, nameSubCategory, descriptionSubCategory, htmlSubCategory, idCategory)
VALUES (4, 'CREATE', NULL, NULL, 2);

INSERT INTO subCategoryTable (idSubCategory, nameSubCategory, descriptionSubCategory, htmlSubCategory, idCategory)
VALUES (5, 'DROP', NULL, NULL, 2);

INSERT INTO subCategoryTable (idSubCategory, nameSubCategory, descriptionSubCategory, htmlSubCategory, idCategory)
VALUES (6, 'ALTER', NULL, NULL, 2);


INSERT INTO subCategoryTable (idSubCategory, nameSubCategory, descriptionSubCategory, htmlSubCategory, idCategory)
VALUES (7, 'GRANT', NULL, NULL, 3);

INSERT INTO subCategoryTable (idSubCategory, nameSubCategory, descriptionSubCategory, htmlSubCategory, idCategory)
VALUES (8, 'REVOKE', NULL, NULL, 3);


INSERT INTO subCategoryTable (idSubCategory, nameSubCategory, descriptionSubCategory, htmlSubCategory, idCategory)
VALUES (9, 'BEGIN', NULL, NULL, 4);

INSERT INTO subCategoryTable (idSubCategory, nameSubCategory, descriptionSubCategory, htmlSubCategory, idCategory)
VALUES (10, 'COMMIT', NULL, NULL, 4);

INSERT INTO subCategoryTable (idSubCategory, nameSubCategory, descriptionSubCategory, htmlSubCategory, idCategory)
VALUES (11, 'ROLLBACK', NULL, NULL, 4);