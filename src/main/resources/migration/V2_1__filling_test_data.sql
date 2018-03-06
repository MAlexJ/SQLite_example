-- -----------------------------------------------------
-- Table categoryTable
-- -----------------------------------------------------
INSERT INTO categoryTable (id, categoryName, description)
VALUES (1, 'dml', 'Data Manipulation Language');

INSERT INTO categoryTable (id, categoryName, description)
VALUES (2, 'ddl', 'Data Definition Language');

INSERT INTO categoryTable (id, categoryName, description)
VALUES (3, 'dcl', 'Data Control Language');

INSERT INTO categoryTable (id, categoryName, description)
VALUES (4, 'tcl', 'Transaction Control Language');

-- -----------------------------------------------------
-- Table subCategoryTable
-- -----------------------------------------------------
INSERT INTO subCategoryTable (id, subCategoryName, description, html, categoryId)
VALUES (1, 'SELECT', NULL, NULL, 1);

INSERT INTO subCategoryTable (id, subCategoryName, description, html, categoryId)
VALUES (2, 'INSERT', NULL, NULL, 1);

INSERT INTO subCategoryTable (id, subCategoryName, description, html, categoryId)
VALUES (3, 'UPDATE', NULL, NULL, 1);


INSERT INTO subCategoryTable (id, subCategoryName, description, html, categoryId)
VALUES (4, 'CREATE', NULL, NULL, 2);

INSERT INTO subCategoryTable (id, subCategoryName, description, html, categoryId)
VALUES (5, 'DROP', NULL, NULL, 2);

INSERT INTO subCategoryTable (id, subCategoryName, description, html, categoryId)
VALUES (6, 'ALTER', NULL, NULL, 2);


INSERT INTO subCategoryTable (id, subCategoryName, description, html, categoryId)
VALUES (7, 'GRANT', NULL, NULL, 3);

INSERT INTO subCategoryTable (id, subCategoryName, description, html, categoryId)
VALUES (8, 'REVOKE', NULL, NULL, 3);


INSERT INTO subCategoryTable (id, subCategoryName, description, html, categoryId)
VALUES (9, 'BEGIN', NULL, NULL, 4);

INSERT INTO subCategoryTable (id, subCategoryName, description, html, categoryId)
VALUES (10, 'COMMIT', NULL, NULL, 4);

INSERT INTO subCategoryTable (id, subCategoryName, description, html, categoryId)
VALUES (11, 'ROLLBACK', NULL, NULL, 4);