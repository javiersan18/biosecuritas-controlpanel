CREATE TABLE `user` (
  id IDENTITY NOT NULL PRIMARY KEY auto_increment,
  username VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  name VARCHAR(255) NOT NULL,
  surname1 VARCHAR(255) NOT NULL,
  surname2 VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  creation_date TIMESTAMP
);

CREATE TABLE `authority` (
  id IDENTITY NOT NULL PRIMARY KEY auto_increment,
  name VARCHAR(255) NOT NULL
);

CREATE TABLE `user_authority` (
  user_id INT NOT NULL,
  authority_id INT NOT NULL,
  PRIMARY KEY (user_id, authority_id),
  FOREIGN KEY (user_id) REFERENCES `user`(id),
  FOREIGN KEY (authority_id) REFERENCES `authority`(id)
  );

  
  
  