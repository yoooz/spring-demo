DROP USER IF EXISTS db_example_1;
CREATE USER db_example_1 IDENTIFIED WITH mysql_native_password BY 'db_example_1';
DROP SCHEMA IF EXISTS db_example_1;
CREATE schema db_example_1;
USE db_example_1
GRANT ALL PRIVILEGES ON db_example_1.* TO 'db_example_1'@'%';

CREATE TABLE user_t
(
	id    INT(10) NOT NULL AUTO_INCREMENT,
	email VARCHAR(255) DEFAULT NULL,
    name  VARCHAR(255) DEFAULT NULL,
    primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP USER IF EXISTS db_example_2;
CREATE USER db_example_2 IDENTIFIED WITH mysql_native_password BY 'db_example_2';
DROP SCHEMA IF EXISTS db_example_2;
CREATE schema db_example_2;
USE db_example_2
GRANT ALL PRIVILEGES ON db_example_2.* TO 'db_example_2'@'%';

CREATE TABLE user_t
(
	id    INT(10) NOT NULL AUTO_INCREMENT,
	email VARCHAR(255) DEFAULT NULL,
    name  VARCHAR(255) DEFAULT NULL,
    primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
