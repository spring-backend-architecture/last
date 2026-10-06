create table account_roles (
    account_id uuid not null references accounts(id),
    role text not null,
    primary key (account_id, role)
);