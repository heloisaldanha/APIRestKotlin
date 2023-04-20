CREATE TABLE reply(
    id INT NOT NULL AUTO_INCREMENT,
    message VARCHAR(500) NOT NULL,
    created_at DATETIME NOT NULL,
    subject_id BIGINT NOT NULL,
    user_client_id BIGINT NOT NULL,
    solved INT NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(subject_id) REFERENCES subject(id),
    FOREIGN KEY(user_client_id) REFERENCES user_client(id)
);