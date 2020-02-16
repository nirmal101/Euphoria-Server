create table LoginCredentials
(
	id INT
		constraint LoginCredentials_pk
			primary key,
	username VARCHAR(50),
	password VARCHAR(255) not null
);

create unique index LoginCredentials_username_uindex
	on LoginCredentials (username);



comment on table LoginCredentials is 'Stores login information about users';

