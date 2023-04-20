CREATE TABLE course(
    id INT NOT NULL auto_increment,
    name VARCHAR(500),
    category VARCHAR(50) NOT NULL,
    PRIMARY KEY(id)
);

INSERT INTO course values(1, 'Kotlin', 'Programacao');