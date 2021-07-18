INSERT INTO users (username, password, enabled)
    VALUES ('user','1234',true);

INSERT INTO users (username, password, enabled)
    VALUES ('admin','pass',true);

INSERT INTO authorities (username,authority)
    VALUES ('user','ROLE_USER');

INSERT INTO authorities (username,authority)
    VALUES ('admin','ROLE_ADMIN')