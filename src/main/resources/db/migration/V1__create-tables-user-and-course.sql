create table `user`(
    id bigint not null auto_increment,
    name varchar(100) not null,
    email varchar(100) not null unique,
    password varchar(200) not null,

    primary key(id)
);

create table course(
    id bigint not null auto_increment,
    name varchar(100),

    primary key(id)
);
