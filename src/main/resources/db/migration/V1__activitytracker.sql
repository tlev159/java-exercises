CREATE TABLE activities (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    start_time TIMESTAMP,
    activity_desc VARCHAR(255),
    activity_type VARCHAR(30));

CREATE TABLE track_point (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
	time TIMESTAMP,
	lat DECIMAL(8,4),
	lon DECIMAL(8,4),
	activityId BIGINT NOT NULL,
	FOREIGN KEY (activityId) REFERENCES activities(id));