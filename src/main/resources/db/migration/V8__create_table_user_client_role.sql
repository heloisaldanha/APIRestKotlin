CREATE TABLE user_client_role(
    id INT NOT NULL AUTO_INCREMENT,
    user_client_id INT NOT NULL,
    role_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY(user_client_id) REFERENCES user_client(id),
    FOREIGN KEY(role_id) REFERENCES role(id)
);

INSERT INTO user_client_role(id, user_client_id, role_id) VALUES(1, 1, 1)