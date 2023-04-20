CREATE TABLE subject(
    id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(50) NOT NULL,
    message VARCHAR(500) NOT NULL,
    created_at DATETIME NOT NULL,
    status VARCHAR(50) NOT NULL,
    course_id INT NOT NULL,
    user_id INT NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(course_id) REFERENCES course(id),
    FOREIGN KEY(user_id) REFERENCES user_client(id)
);