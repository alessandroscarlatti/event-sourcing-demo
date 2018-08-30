create table if not exists TODO (
    ID INT auto_increment,
    TEXT varchar(60),
    COMPLETED_IND CHAR
);

create table if not exists todo_event (
    id int auto_increment
)