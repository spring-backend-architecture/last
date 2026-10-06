create table users (
    username varchar(15)  not null primary key,
    password varchar(500) not null,
    enabled  boolean      not null,
    constraint ck_users_username_phone check (username ~ '^[0-9]{10,15}$')
);

