insert into book
(ID, TITLE, AUTHOR, PRICE_IN_EURO)
values
(nextval('book_seq'), 'MaddAddam', 'Margaret Atwood', 10);
insert into book
(ID, TITLE, AUTHOR, PRICE_IN_EURO)
values
(nextval('book_seq'), 'The year of the flood', 'Margaret Atwood', 15);
insert into book
(ID, TITLE, AUTHOR, PRICE_IN_EURO)
values
(nextval('book_seq'), 'Oryx and Crake', 'Margaret Atwood', 20);
insert into genre
(ID, NAME)
values
(nextval('genre_seq'), 'Spanning');
insert into genre
(ID, NAME)
values
(nextval('genre_seq'), 'Thriller');
insert into genre
(ID, NAME)
values
(nextval('genre_seq'), 'Fantasy & Sciencefiction');
insert into genre
(ID, NAME)
values
(nextval('genre_seq'), 'Roman');

insert into user
(ID, USERNAME, PASSWORD, ROLE)
values
(nextval('user_seq'), 'Talha', '$2y$12$zDKNuSz4mdEz1zmXNKgWUOFs/z5ax7SyT/t7MSQ19VweyFo4qZbdO', 'USER');