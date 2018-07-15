drop table jdbcitems;

create  table jdbcitems(item_id  integer constraint jdbcitem_PK primary key,
item_name varchar(20), item_cost  decimal(7,2));

insert into  jdbcitems values(1000, 'Lux', 36.5);
insert into  jdbcitems values(1010, 'Marvel', 32.5);
insert into  jdbcitems values(1020, 'Cinthol', 31.5);
insert into  jdbcitems values(1030, 'Dove', 45.5);
insert into  jdbcitems values(1040, 'Pears', 52.5);
 