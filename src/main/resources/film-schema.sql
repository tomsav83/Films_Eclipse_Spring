drop table if exists `film` CASCADE;
CREATE TABLE `film` (
	`id` integer PRIMARY KEY AUTO_INCREMENT,
	`cost` double not null,
	`genre` varchar(255) not null,
	`name` varchar(255)
);