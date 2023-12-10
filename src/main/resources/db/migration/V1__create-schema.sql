create table repository
(
    id   bigint auto_increment primary key,
    name varchar(255) not null,
    constraint UK_name unique (name)
);

create table repository_property
(
    id             bigint auto_increment primary key,
    property_key   varchar(255) not null,
    property_value varchar(255) not null,
    repository_id  bigint,
    foreign key (repository_id) references repository (id)
);

create table node
(
    id            bigint auto_increment primary key,
    path          varchar(255) not null,
    name          varchar(255) not null,
    depth         int          not null,
    repository_id bigint,
    foreign key (repository_id) references repository (id)
);

create table node_property
(
    id             bigint auto_increment primary key,
    property_key   varchar(255) not null,
    property_value varchar(255) not null,
    node_id        bigint,
    foreign key (node_id) references node (id)
);
