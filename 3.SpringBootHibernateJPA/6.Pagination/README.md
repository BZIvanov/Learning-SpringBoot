# Pagination demo

Some of the boilerplate code from the initial project was removed for somplicity for the demo.

## Database genetation

Use the below code to generate your database and database user.

```sql
CREATE DATABASE IF NOT EXISTS `expense_tracker`;
USE `expense_tracker`;

DROP USER if exists 'springstudent'@'%' ;
CREATE USER 'springstudent'@'%' IDENTIFIED BY '12345678';
GRANT ALL PRIVILEGES ON expense_tracker.* TO 'springstudent'@'%';
FLUSH PRIVILEGES;
-- verify the user was created
SELECT user, host FROM mysql.user;

SELECT * FROM expenses;
```
