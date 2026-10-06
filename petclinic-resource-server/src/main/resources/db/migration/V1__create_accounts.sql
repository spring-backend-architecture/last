create table accounts (
    id uuid primary key,
    username text not null unique
);