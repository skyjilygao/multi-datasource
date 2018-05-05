create table t_user
(
	id int auto_increment
		primary key,
	name varchar(255) not null,
	loginName varchar(255) not null,
	roleName varchar(255) not null,
	createTime timestamp null,
	lastLoginTime timestamp null,
	dataFlag int(2) default '0' null,
	password varchar(255) not null
)
;

