-- -----------------------------------------------------
-- Table html page content
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS html_content (
  id            INTEGER,
  category_name VARCHAR(45) NOT NULL,
  html          TEXT,
  PRIMARY KEY (id)
);

-- -----------------------------------------------------
-- Table category
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS category (
  id                INTEGER,
  name              VARCHAR(45) NOT NULL,
  description       VARCHAR(45) NULL,
  position          INTEGER NOT NULL,
  html_content_id   INTEGER,
  category_id       INTEGER,
  PRIMARY KEY (id),
  CONSTRAINT fk_category_html_content_id FOREIGN KEY (html_content_id)
  REFERENCES html_content (id),
  CONSTRAINT fk_category_id FOREIGN KEY (category_id)
  REFERENCES category (id)
);