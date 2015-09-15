-- Table definitions for the server side database.


CREATE TABLE RESTAURANTS (
	business_id VARCHAR(255) NOT NULL ,
	full_address VARCHAR(255) ,
	categories VARCHAR(255) ,
	city VARCHAR(255) ,
	state VARCHAR(255) ,
	name VARCHAR(255) ,
	stars FLOAT ,
	longitude FLOAT ,
	latitude FLOAT ,
	PRIMARY KEY (business_id)
);

CREATE TABLE USERS (
	user_id VARCHAR(255) NOT NULL ,
	first_name VARCHAR(255) ,
	last_name VARCHAR(255) ,
	PRIMARY KEY (user_id)
);

CREATE TABLE USER_VISIT_HISTORY(
	visit_history_id bigint(20) unsigned NOT NULL AUTO_INCREMENT ,
	user_id VARCHAR(255) NOT NULL ,
	business_id VARCHAR(255) NOT NULL ,
	last_visited_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (visit_history_id),
	FOREIGN KEY (business_id) REFERENCES RESTAURANTS(business_id),
	FOREIGN KEY (user_id) REFERENCES USERS(user_id)
);
