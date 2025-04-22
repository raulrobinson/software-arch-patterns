CREATE TABLE IF NOT EXISTS users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    email VARCHAR(255)
);

--INSERT INTO users (name, email) VALUES ('Juan', 'juan@demo.com'), ('María', 'maria@demo.com');
