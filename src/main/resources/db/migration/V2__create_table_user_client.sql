CREATE TABLE user_client(
    id INT NOT NULL auto_increment,
    name VARCHAR(50),
    email VARCHAR(50) NOT NULL,
    PRIMARY KEY(id)
);

INSERT INTO user_client values(1, 'Heloisa', 'heloisa@email.com');