CREATE TABLE PersonJdbc(
    id integer not null,
    name varchar(255) not null,
    location varchar(255),
    birth_date timestamp,
    PRIMARY KEY (id)
);

INSERT INTO PersonJdbc
VALUES (10001,'Alex','Ukraine',sysdate());
INSERT INTO PersonJdbc
VALUES (10002,'John','USA',sysdate());
INSERT INTO PersonJdbc
VALUES (10003,'Jack','Canada',sysdate());

INSERT INTO Person (ID, NAME, LOCATION, BIRTH_DATE)
VALUES (10001,'Alex','Ukraine',sysdate());
INSERT INTO Person (ID, NAME, LOCATION, BIRTH_DATE)
VALUES (10002,'John','USA',sysdate());
INSERT INTO Person (ID, NAME, LOCATION, BIRTH_DATE)
VALUES (10003,'Jack','Canada',sysdate());