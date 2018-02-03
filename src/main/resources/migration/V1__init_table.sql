CREATE TABLE IF NOT EXISTS categoryDefinitionTable
(
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  category TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS userTable
(
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  firstName TEXT,
  lastName TEXT,
  email TEXT UNIQUE NOT NULL,
  password TEXT NOT NULL,
  gender TEXT,
  dateOfBridge date,
  avatar BLOB,
  confirm boolean,
  role INTEGER,
  phone INTEGER,
  address INTEGER,
  language INTEGER 
);

CREATE TABLE IF NOT EXISTS counrtyCodeTable
(
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  phoneCode TEXT NOT NULL,
  isoCode TEXT NOT NULL,
  country TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS phoneTable
(
  id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
  phone TEXT NOT NULL,
  phoneCodeId INTEGER NOT NULL,
  constraint phoneTable_counrtyCodeTable_id_fk
  foreign key ( phoneCodeId ) references counrtyCodeTable (id)
);

CREATE TABLE IF NOT EXISTS addressTable
(
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  countryId INTEGER NOT NULL,
  street TEXT,
  apartment TEXT,
  constraint addressTable_counrtyCodeTable_id_fk
  foreign key ( countryId ) references counrtyCodeTable (id)
);