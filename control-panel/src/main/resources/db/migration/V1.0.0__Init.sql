CREATE TABLE `user` (
  id IDENTITY NOT NULL PRIMARY KEY,
  username  VARCHAR(50) NOT NULL,
  password  VARCHAR(255) NOT NULL,
  email  VARCHAR(255) NOT NULL,
  date_created TIMESTAMP
);

CREATE TABLE `authority` (
  id IDENTITY NOT NULL PRIMARY KEY,
  name VARCHAR(255) NOT NULL
);

CREATE TABLE `user_authority` (
  user_id INT NOT NULL,
  authority_id INT NOT NULL,
  PRIMARY KEY (user_id, authority_id),
  FOREIGN KEY (user_id) REFERENCES `user`(id),
  FOREIGN KEY (authority_id) REFERENCES `authority`(id)
  );

  
  
  