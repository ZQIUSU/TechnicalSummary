drop table if exists `coffee`;
drop table if exists `order`;
drop table if exists `coffee_order`;


CREATE TABLE `coffee` (
  `id` bigint auto_increment,
  `create_time` datetime(6) DEFAULT NULL,
  `update_time` datetime(6) DEFAULT NULL,
  `coffee_name` varchar(255) DEFAULT NULL,
  `price` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `order` (
  `id` bigint auto_increment,
  `create_time` datetime(6) DEFAULT NULL,
  `update_time` datetime(6) DEFAULT NULL,
  `customer` varchar(25) NOT NULL,
  `state` INTEGER NOT NULL,
  primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

create table coffee_order (
	id bigint auto_increment,
	coffee_order_id bigint,
	items_id bigint ,
	primary key(id)
)

insert into `coffee` (name,price,create_time,update_time) values (`latte`,2500,now(),now())
insert into `coffee` (name,price,create_time,update_time) values (`espresso`,2000,now(),now())
insert into `coffee` (name,price,create_time,update_time) values (`cappuccino`,2500,now(),now())
insert into `coffee` (name,price,create_time,update_time) values (`mocha`,3000,now(),now())
insert into `coffee` (name,price,create_time,update_time) values (`macchiato`,3000,now(),now())
