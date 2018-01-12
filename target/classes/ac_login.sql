DROP DATABASE IF EXISTS ac_login;
CREATE DATABASE ac_login;
USE ac_login;

CREATE TABLE users (
  user_name CHAR(128) NOT NULL ,
  password CHAR(18) NOT NULL ,
  email CHAR(50) NOT NULL ,
  PRIMARY KEY (user_name)
);