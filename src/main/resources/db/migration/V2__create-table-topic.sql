create table topic(
    id bigint not null auto_increment,
    title varchar(100) not null,
    message varchar(250) not null,
    create_date datetime not null,
    status varchar(100) not null,

    author_id bigint not null,
    course_id bigint not null,

    primary key(id),
    constraint fk_topic_user_id foreign key(author_id) references user(id),
    constraint fk_topic_course_id foreign key(course_id) references course(id)
);