ALTER SEQUENCE HIBERNATE_SEQUENCE RESTART WITH 0 minvalue 0;
insert into book
(ID, TITLE, AUTHOR, SELLS)
values
(nextval('HIBERNATE_SEQUENCE'), 'MaddAddam', 'Margaret Atwood', 200000);
insert into book
(ID, TITLE, AUTHOR, SELLS)
values
(nextval('HIBERNATE_SEQUENCE'), 'The year of the flood', 'Margaret Atwood', 400000);
insert into book
(ID, TITLE, AUTHOR, SELLS)
values
(nextval('HIBERNATE_SEQUENCE'), 'Oryx and Crake', 'Margaret Atwood', 150000);