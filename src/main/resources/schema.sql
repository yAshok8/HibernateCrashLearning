/*-- Address entity for one-to-one relationship
CREATE TABLE IF NOT EXISTS ADDRESS (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    street VARCHAR(255),
    city VARCHAR(255),
    zipCode VARCHAR(10)
);

-- User entity for one-to-one relationship
CREATE TABLE IF NOT EXISTS Users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50),
    address_id BIGINT,
    FOREIGN KEY (address_id) REFERENCES Address(id)
);*/

DROP TABLE IF EXISTS Employee;
DROP TABLE IF EXISTS Department;

-- Department entity for one-to-many relationship
CREATE TABLE IF NOT EXISTS Department (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100)
);

-- Employee entity for one-to-many and many-to-one relationships
CREATE TABLE IF NOT EXISTS Employee (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    department_id BIGINT,
    FOREIGN KEY (department_id) REFERENCES Department(id)
);

DROP TABLE IF EXISTS author_book;
DROP TABLE IF EXISTS author;
DROP TABLE IF EXISTS book;

-- Author entity for many-to-many relationship
CREATE TABLE IF NOT EXISTS AUTHOR (
    author_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100)
);

-- Book entity for many-to-many relationship
CREATE TABLE IF NOT EXISTS BOOK (
    book_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255)
);

-- Join table for the many-to-many relationship between Author and Book
CREATE TABLE IF NOT EXISTS author_book (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    author_id BIGINT,
    book_id BIGINT,
    FOREIGN KEY (author_id) REFERENCES Author(author_id),
    FOREIGN KEY (book_id) REFERENCES Book(book_id)
);
