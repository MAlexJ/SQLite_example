-- -----------------------------------------------------
-- fill html_content table
-- -----------------------------------------------------
INSERT INTO html_content (id, category_name, html)
VALUES (1, 'DML', '<h3>Data Manipulation Language</h3><p>Text dml!</p>'),
       (2, 'DDL', '<h3>Data Definition Language</h3><p>Text ddl!</p>'),
       (3, 'DCL', '<h3>Data Control Language</h3><p>Text dcl!</p>'),
       (4, 'TCL', '<h3>Transaction Control Language</h3><p>Text tcl!</p>'),
       (5, 'SELECT', '<h3>SELECT</h3><p>html SELECT!</p>'),
       (6, 'INSERT', '<h3>INSERT</h3><p>html INSERT!</p>'),
       (7, 'UPDATE', '<h3>UPDATE</h3><p>html UPDATE!</p>'),
       (8, 'CREATE', '<h3>CREATE</h3><p>html CREATE!</p>'),
       (9, 'DROP', '<h3>DROP</h3><p>html DROP!</p>'),
       (10, 'ALTER', '<h3>ALTER</h3><p>html ALTER!</p>'),
       (11, 'GRANT', '<h3>GRANT</h3><p>html GRANT!</p>'),
       (12, 'REVOKE', '<h3>REVOKE</h3><p>html REVOKE!</p>'),
       (13, 'BEGIN', '<h3>BEGIN</h3><p>html BEGIN!</p>'),
       (14, 'COMMIT', '<h3>COMMIT</h3><p>html COMMIT!</p>'),
       (15, 'ROLLBACK', '<h3>ROLLBACK</h3><p>html ROLLBACK!</p>');

-- -----------------------------------------------------
-- fill category table
-- -----------------------------------------------------
INSERT INTO category (id, name, description, position, html_content_id)
VALUES (1, 'DML', 'Data Manipulation Language', 1, 1),
       (2, 'DDL', 'Data Definition Language', 2, 2),
       (3, 'DCL', 'Data Control Language', 3, 3),
       (4, 'TCL', 'Transaction Control Language', 4, 4);

INSERT INTO category (id, name, html_content_id, position, category_id)
VALUES (5, 'SELECT', 5, 1, 1),
       (6, 'INSERT', 6, 2, 1),
       (7, 'UPDATE', 7, 3, 1),
       (8, 'CREATE', 8, 1, 2),
       (9, 'DROP', 9, 2, 2),
       (10, 'ALTER', 10, 3, 2),
       (11, 'GRANT', 11, 1, 3),
       (12, 'REVOKE', 12, 2, 3),
       (13, 'BEGIN', 13, 1, 4),
       (14, 'COMMIT', 14, 2, 4),
       (15, 'ROLLBACK', 15, 3, 4);


