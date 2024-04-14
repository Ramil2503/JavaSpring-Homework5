create table task (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(100) NOT NULL,
    status varchar(15) NOT NULL,
    creation_date DATE NOT NULL
);