create table authorities (
    username  varchar(15) not null,
    authority varchar(50) not null default 'ROLE_USER',
    constraint pk_authorities primary key (username, authority),
    constraint fk_authorities_users foreign key (username) references users (username)
);