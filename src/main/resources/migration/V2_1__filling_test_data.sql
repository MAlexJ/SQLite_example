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
INSERT INTO subCategoryTable (idSubCategory, nameSubCategory, htmlSubCategory, idCategory)
VALUES (1, 'SELECT', '<h3>SELECT</h3><p>html SELECT!</p>', 1);

INSERT INTO subCategoryTable (idSubCategory, nameSubCategory, htmlSubCategory, idCategory)
VALUES (2, 'INSERT', '<h3>INSERT</h3><p>html INSERT!</p>', 1);

INSERT INTO subCategoryTable (idSubCategory, nameSubCategory, htmlSubCategory, idCategory)
VALUES (3, 'UPDATE', '<h3>UPDATE</h3><p>html UPDATE!</p>', 1);


INSERT INTO subCategoryTable (idSubCategory, nameSubCategory, htmlSubCategory, idCategory)
VALUES (4, 'CREATE', '<h3>CREATE</h3><p>html CREATE!</p>', 2);

INSERT INTO subCategoryTable (idSubCategory, nameSubCategory, htmlSubCategory, idCategory)
VALUES (5, 'DROP', '<h3>DROP</h3><p>html DROP!</p>', 2);

INSERT INTO subCategoryTable (idSubCategory, nameSubCategory, htmlSubCategory, idCategory)
VALUES (6, 'ALTER', '<h3>ALTER</h3><p>html ALTER!</p>', 2);


INSERT INTO subCategoryTable (idSubCategory, nameSubCategory, htmlSubCategory, idCategory)
VALUES (7, 'GRANT', '<h3>GRANT</h3><p>html GRANT!</p>', 3);

INSERT INTO subCategoryTable (idSubCategory, nameSubCategory, htmlSubCategory, idCategory)
VALUES (8, 'REVOKE', '<h3>REVOKE</h3><p>html REVOKE!</p>', 3);


INSERT INTO subCategoryTable (idSubCategory, nameSubCategory, htmlSubCategory, idCategory)
VALUES (9, 'BEGIN', '<h3>BEGIN</h3><p>html BEGIN!</p>', 4);

INSERT INTO subCategoryTable (idSubCategory, nameSubCategory, htmlSubCategory, idCategory)
VALUES (10, 'COMMIT', '<h3>COMMIT</h3><p>html COMMIT!</p>', 4);

INSERT INTO subCategoryTable (idSubCategory, nameSubCategory, htmlSubCategory, idCategory)
VALUES (11, 'ROLLBACK', '<h3>ROLLBACK</h3><p>html ROLLBACK!</p>', 4);