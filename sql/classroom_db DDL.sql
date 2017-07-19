CREATE USER classroom_db IDENTIFIED BY p4ssw0rd;
GRANT CONNECT, RESOURCE TO  classroom_db;


--create lookup table u_role
CREATE TABLE user_role(
  u_role_id INT,
  u_role VARCHAR2(4000) UNIQUE NOT NULL,
  PRIMARY KEY(u_role_id)
);
DROP TABLE users;
--create users table
CREATE TABLE users(
  u_id INT,
  u_role_id INT NOT NULL,
  u_username VARCHAR2(4000) UNIQUE NOT NULL,
  u_password VARCHAR2(4000) NOT NULL,
  u_email VARCHAR2(4000) NOT NULL,
  u_fname VARCHAR2(4000) NOT NULL,
  u_lname VARCHAR2(4000) NOT NULL,
  PRIMARY KEY(u_id),
  FOREIGN KEY(u_role_id) REFERENCES user_role(u_role_id)
);
