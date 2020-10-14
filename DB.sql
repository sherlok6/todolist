-- auto-generated definition
create table fix_list
(
    id    int4 default nextval('fix_list_id_seq'::regclass) not null
        constraint fix_list_pkey
            unique,
    task  varchar                                           not null,
    login varchar,
    state varchar
);

-- auto-generated definition
create table fix_user
(
    id        int4    default nextval('fix_user_id_seq'::regclass) not null,
    firstname varchar                                              not null,
    lastname  varchar                                              not null,
    login     varchar                                              not null,
    state     varchar default 'ACTIVE',
    role      varchar default 'USER',
    hash_pass varchar,
    constraint fix_user_pkey
        primary key (id, login)
);

