DROP USER IF EXISTS db_common;
CREATE USER db_common IDENTIFIED WITH mysql_native_password BY 'db_common';
DROP SCHEMA IF EXISTS db_common;
CREATE schema db_common;
USE db_common
GRANT ALL PRIVILEGES ON db_common.* TO 'db_common'@'%';

CREATE TABLE connect_t
(
	db_name VARCHAR(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO connect_t VALUES ("db_1"), ("db_2");

DROP USER IF EXISTS db_1;
CREATE USER db_1 IDENTIFIED WITH mysql_native_password BY 'db_1';
DROP SCHEMA IF EXISTS db_1;
CREATE schema db_1;
USE db_1
GRANT ALL PRIVILEGES ON db_1.* TO 'db_1'@'%';

CREATE TABLE user_t
(
	id    INT(10) NOT NULL AUTO_INCREMENT,
	email VARCHAR(255) DEFAULT NULL,
    name  VARCHAR(255) DEFAULT NULL,
    primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP USER IF EXISTS db_2;
CREATE USER db_2 IDENTIFIED WITH mysql_native_password BY 'db_2';
DROP SCHEMA IF EXISTS db_2;
CREATE schema db_2;
USE db_2
GRANT ALL PRIVILEGES ON db_2.* TO 'db_2'@'%';

CREATE TABLE user_t
(
	id    INT(10) NOT NULL AUTO_INCREMENT,
	email VARCHAR(255) DEFAULT NULL,
    name  VARCHAR(255) DEFAULT NULL,
    primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
