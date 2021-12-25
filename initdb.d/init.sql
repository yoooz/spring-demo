DROP USER IF EXISTS db_example_1;
CREATE USER db_example_1 IDENTIFIED WITH mysql_native_password BY 'db_example_1';
DROP SCHEMA IF EXISTS db_example_1;
CREATE schema db_example_1;
GRANT ALL PRIVILEGES ON db_example_1.* TO 'db_example_1'@'%';
