create table test_groups
(
    name       varchar(40) not null,
    test_value integer     not null,
    unique (name)
);

create table test_cases
(
    id         integer     not null,
    group_name varchar(40) not null,
    status     varchar(5)  not null,
    unique (id)
);

select tg.name,
       ifnull(t1.cnt, 0)                 as all_test_cases,
       ifnull(t2.cnt, 0)                 as passed_test_cases,
       ifnull(t2.cnt, 0) * tg.test_value as total_value
from test_groups tg
         left join (
    select count(*) cnt, group_name
    from test_cases
    group by group_name
) t1 on t1.group_name = tg.name
         left join (
    select count(*) cnt, group_name
    from test_cases
    where status = 'OK'
    group by group_name
) t2 on t2.group_name = tg.name
order by total_value desc, tg.name;

insert into test_groups
values ('performance', 15);
insert into test_groups
values ('corner cases', 10);
insert into test_groups
values ('numerical stability', 20);
insert into test_groups
values ('memory usage', 10);
insert into test_cases
values (13, 'memory usage', 'OK');
insert into test_cases
values (14, 'numerical stability', 'OK');
insert into test_cases
values (15, 'memory usage', 'ERROR');
insert into test_cases
values (16, 'numerical stability', 'OK');
insert into test_cases
values (17, 'numerical stability', 'OK');
insert into test_cases
values (18, 'performance', 'ERROR');
insert into test_cases
values (19, 'performance', 'ERROR');
insert into test_cases
values (20, 'memory usage', 'OK');
insert into test_cases
values (21, 'numerical stability', 'OK');
