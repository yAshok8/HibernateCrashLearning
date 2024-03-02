-- Author entity
INSERT INTO AUTHOR (name) VALUES
('Vedant Yadav'),
('Babita Yadav'),
('Mukesh Gupta'),
('Rhonda Baryne'),
('Ashok Yadav'),
('Santosh Yadav'),
('Kumar Sanu'),
('Sadhguru'),
('JK Rowling'),
('Nepolican Hill');

-- Book entity
INSERT INTO BOOK (title) VALUES
('The Secret'),
('The power of subconscious mind'),
('The 4 hour work week'),
('The mountain lust'),
('Eat that frog'),
('Momentum'),
('Death'),
('48 Rules of Power'),
('The Brainstorms'),
('Harry Potter');

-- Join table for many-to-many relationship between Author and Book
INSERT INTO author_book (author_id, book_id) VALUES
(1, 1),
(2, 5),
(1, 3),
(4, 1),
(5, 2),
(5, 6),
(6, 9),
(2, 9),
(7, 2),
(8, 4),
(8, 7),
(3, 8),
(3, 5),
(10, 3);

-- Inserting data into Department table
INSERT INTO Department (name) VALUES
('HR'),
('Finance'),
('IT'),
('Marketing'),
('Sales'),
('Engineering'),
('Customer Service'),
('Research and Development'),
('Legal'),
('Operations');

-- Inserting data into Employee table
INSERT INTO Employee (name, department_id) VALUES
('John Doe', 1),
('Jane Smith', 2),
('Bob Johnson', 3),
('Alice Brown', 4),
('Chris Davis', 5),
('Eva Wilson', 6),
('Mike Anderson', 7),
('Sophie White', 8),
('David Taylor', 9),
('Emily Clark', 10),
('Mark Miller', 1),
('Laura Turner', 2),
('Alex Harris', 3),
('Olivia Lee', 4),
('Daniel Martinez', 5),
('Grace Thomas', 6),
('Kevin Rodriguez', 7),
('Chloe Walker', 8),
('Brian King', 9),
('Lily Hall', 10);
