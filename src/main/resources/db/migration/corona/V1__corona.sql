CREATE TABLE cities (
	city_id BIGINT(20) NOT NULL DEFAULT '0',
	city VARCHAR(100) NOT NULL,
	city_part VARCHAR(100),
	order_id INT(11) NOT NULL,
	shipment_date DATE NOT NULL,
	PRIMARY KEY (city_id)
	);

CREATE TABLE citizens (
	citizen_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	citizen_name VARCHAR(200) NOT NULL,
	zip BIGINT(5) NOT NULL,
	age BIGINT NOT NULL,
	email VARCHAR(200),
	taj VARCHAR(10),
	number_of_vaccination BIGINT DEFAULT '0',
	last_vaccination DATETIME
);

CREATE TABLE vaccinations (
	vaccination_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	citizen_id BIGINT NOT NULL,
	vaccination_date DATETIME NOT NULL,
	`status` VARCHAR(10),
	note VARCHAR(200),
	vaccination_type VARCHAR(200),
	CONSTRAINT `citizenId` FOREIGN KEY (`citizen_id`) REFERENCES `corona`.`citizens` (`citizen_id`) ON UPDATE NO ACTION ON DELETE NO ACTION
);
