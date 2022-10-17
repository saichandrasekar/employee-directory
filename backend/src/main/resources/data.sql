insert into DEPARTMENT(DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID) values (1,'ADMIN',null);
insert into DEPARTMENT(DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID) values (2,'IT',null);
insert into DEPARTMENT(DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID) values (3,'HR',null);

insert into EMPLOYEE (EMPLOYEE_ID ,DEPARTMENT_ID ,EMAIL ,FIRST_NAME ,HIRE_DATE ,LAST_NAME ,MANAGER_ID ,PHONE_NUMBER ,SALARY ) values (1, 1, 'john_doe@mayur.com', 'John', CURRENT_DATE(), 'Doe', null, '917-852-9865', 0.0);
insert into EMPLOYEE (EMPLOYEE_ID ,DEPARTMENT_ID ,EMAIL ,FIRST_NAME ,HIRE_DATE ,LAST_NAME ,MANAGER_ID ,PHONE_NUMBER ,SALARY ) values (2, 2, 'sam_nickel@mayur.com', 'Sam', CURRENT_DATE(), 'Nickel', null, '917-456-9865', 0.0);
insert into EMPLOYEE (EMPLOYEE_ID ,DEPARTMENT_ID ,EMAIL ,FIRST_NAME ,HIRE_DATE ,LAST_NAME ,MANAGER_ID ,PHONE_NUMBER ,SALARY ) values (3, 3, 'august_rim@mayur.com', 'August', CURRENT_DATE(), 'Rim', null, '917-789-9865', 0.0);

update DEPARTMENT set MANAGER_ID =1 where DEPARTMENT_ID =1;
update DEPARTMENT set MANAGER_ID =2 where DEPARTMENT_ID =2;
update DEPARTMENT set MANAGER_ID =3 where DEPARTMENT_ID =3;

insert into EMPLOYEE (EMPLOYEE_ID ,DEPARTMENT_ID ,EMAIL ,FIRST_NAME ,HIRE_DATE ,LAST_NAME ,MANAGER_ID ,PHONE_NUMBER ,SALARY ) values (4, 1, 'bill_trucker@mayur.com', 'Bill', CURRENT_DATE(), 'Trucker', 1, '917-753-9865', 0.0);
insert into EMPLOYEE (EMPLOYEE_ID ,DEPARTMENT_ID ,EMAIL ,FIRST_NAME ,HIRE_DATE ,LAST_NAME ,MANAGER_ID ,PHONE_NUMBER ,SALARY ) values (5, 1, 'cassy_win@mayur.com', 'Cassy', CURRENT_DATE(), 'Win', 1, '917-754-9865', 0.0);
insert into EMPLOYEE (EMPLOYEE_ID ,DEPARTMENT_ID ,EMAIL ,FIRST_NAME ,HIRE_DATE ,LAST_NAME ,MANAGER_ID ,PHONE_NUMBER ,SALARY ) values (6, 2, 'donald_smith@mayur.com', 'Donald', CURRENT_DATE(), 'Smith', 2, '917-865-9865', 0.0);
insert into EMPLOYEE (EMPLOYEE_ID ,DEPARTMENT_ID ,EMAIL ,FIRST_NAME ,HIRE_DATE ,LAST_NAME ,MANAGER_ID ,PHONE_NUMBER ,SALARY ) values (7, 2, 'jack_reel@mayur.com', 'Jack', CURRENT_DATE(), 'Reel', 2, '917-958-9865', 0.0);
insert into EMPLOYEE (EMPLOYEE_ID ,DEPARTMENT_ID ,EMAIL ,FIRST_NAME ,HIRE_DATE ,LAST_NAME ,MANAGER_ID ,PHONE_NUMBER ,SALARY ) values (8, 3, 'larry_page@mayur.com', 'Larry', CURRENT_DATE(), 'Page', 3, '917-356-9865', 0.0);
insert into EMPLOYEE (EMPLOYEE_ID ,DEPARTMENT_ID ,EMAIL ,FIRST_NAME ,HIRE_DATE ,LAST_NAME ,MANAGER_ID ,PHONE_NUMBER ,SALARY ) values (9, 3, 'mayur_song@mayur.com', 'Mayur', CURRENT_DATE(), 'Song', 3, '917-246-9865', 0.0);
