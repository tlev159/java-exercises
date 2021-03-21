CREATE TABLE cities (
city_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
zip VARCHAR2(4),
city VARCHAR2(40)
);

CREATE TABLE citizens (
citizen_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
citizen_name VARCHAR2(200) NOT NULL,
zip BIGINT(5) NOT NULL,
age BIGINT (3) NOT NULL,
email VARCHAR2(100),
taj VARCHAR2(10),
number_of_vaccination BIGINT DEFAULT '0',
last_vaccination DATETIME
);

CREATE TABLE vaccinations (
vaccination_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
citizen_id BIGINT NOT NULL,
vaccination_date DATETIME NOT NULL,
`status` VARCHAR2(10),
note VARCHAR2(200),
vaccination_type VARCHAR2(20),
CONSTRAINT `citizenId` FOREIGN KEY (`citizen_id`) REFERENCES `corona`.`citizens` (`citizen_id`) ON UPDATE CASCADE ON ON DELETE CASCADE ON
);