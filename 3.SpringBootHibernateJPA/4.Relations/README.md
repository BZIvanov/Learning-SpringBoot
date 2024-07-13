# Relations

## MySQL setup

Create the database user, which we will use for the database.

```sql
CREATE USER 'springstudent'@'%' IDENTIFIED BY '12345678';

GRANT ALL PRIVILEGES ON * . * TO 'springstudent'@'%';
```

Run the below sql script to create the database and tables.

```sql
CREATE DATABASE social_network;
USE social_network;

-- Disable foreign key checks
SET FOREIGN_KEY_CHECKS = 0;

CREATE TABLE profile_pictures (
	  id INT NOT NULL AUTO_INCREMENT,
	  picture_url varchar(128) NOT NULL,
	  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

CREATE TABLE users (
	  id INT NOT NULL AUTO_INCREMENT,
	  first_name varchar(45) DEFAULT NULL,
	  last_name varchar(45) DEFAULT NULL,
    profile_picture_id INT DEFAULT NULL,
	  PRIMARY KEY (id),
    UNIQUE KEY users_profile_picture_id_unique_idx (profile_picture_id),
    CONSTRAINT FK_PROFILE_PICTURE FOREIGN KEY (profile_picture_id) REFERENCES profile_pictures (id) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

CREATE TABLE posts (
    id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    user_id INT NOT NULL,
    PRIMARY KEY (id),
    KEY posts_user_id_idx (user_id),
    CONSTRAINT FK_USER_POSTS FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

-- Re-enable foreign key checks
SET FOREIGN_KEY_CHECKS = 1;

SELECT * FROM users;
SELECT * FROM profile_pictures;
SELECT * FROM posts;
```

## Project configs

Here is a list of how this project was configured in the Spring Initializr

- Project: Maven
- Language: Java
- Spring Boot: 3.3.1
- Project Metadata:
  - Group: com.example
  - Artifact: demo
  - Name: demo
  - Description: Demo project for Spring Boot
  - Package Name: com.example.demo
  - Packaging: JAR
  - Java: 22
- Dependencies:
  - Spring Data JPA
  - MySQL Driver
