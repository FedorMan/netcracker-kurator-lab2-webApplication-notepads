CREATE USER notepadmanager@localhost
  IDENTIFIED BY '123123';
GRANT USAGE ON *.* TO notepadmanager@localhost
IDENTIFIED BY '123123';
CREATE DATABASE IF NOT EXISTS notepadmanager;
GRANT ALL PRIVILEGES ON notepadmanager.* TO notepadmanager@localhost;
USE notepadmanager;

CREATE TABLE users
(
  id       INT PRIMARY KEY AUTO_INCREMENT,
  login    VARCHAR(50) UNIQUE,
  password VARCHAR(70),
  time_create TIMESTAMP
);

CREATE TABLE notepads
(
  id          INT PRIMARY KEY AUTO_INCREMENT,
  id_user     INT,
  name        VARCHAR(200),
  time_create TIMESTAMP,
  FOREIGN KEY (id_user)
  REFERENCES users (id)
    ON DELETE CASCADE
);


CREATE TABLE recording
(
  id          INT PRIMARY KEY AUTO_INCREMENT,
  id_notepad  INT,
  name        VARCHAR(200),
  text        VARCHAR(3000),
  time_create TIMESTAMP,
  FOREIGN KEY (id_notepad)
  REFERENCES notepads (id)
    ON DELETE CASCADE
);

CREATE TABLE saved_files
(
  id           INT PRIMARY KEY AUTO_INCREMENT,
  id_record    INT,
  path_to_file VARCHAR(200),
  time_create  TIMESTAMP,
  type enum("txt","picture","sound","files") default("files"),
  FOREIGN KEY (id_record)
  REFERENCES recording (id)
    ON DELETE CASCADE
);

COMMIT;