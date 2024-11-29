create table answer(
    id bigint not null auto_increment,
    message varchar(250),
    solution varchar(250),
    create_date datetime not null,

    topic_id bigint not null,
    author_id bigint not null,

    primary key(id),
    constraint fk_answer_topic_id foreign key(topic_id) references topic(id),
    constraint fk_answer_user_id foreign key(author_id) references user(id)
);