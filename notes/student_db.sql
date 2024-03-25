-- Createing a database.
-- DROP DATABASE demos' -- Use this to delete database.
-- CREATE  DATABASE demos;

/* 
 * Multi line comment.
 *
 */

-- DDL
DROP TABLE IF EXISTS students;
DROP TABLE IF EXISTS addresses;

CREATE TABLE students (
	s_name VARCHAR(50) NOT NULL,
	id INT PRIMARY KEY AUTO_INCREMENT,
	gpa NUMERIC(3, 2) CHECK(gpa >= 0 AND gpa <= 4),
	gender VARCHAR(15) NOT NULL DEFAULT("unknown")
);

CREATE TABLE addresses (
	addr_id INT PRIMARY KEY AUTO_INCREMENT,
	street_addr VARCHAR(100),
	city VARCHAR(50),
	region VARCHAR(50),
	postal_code VARCHAR(15),
	student_id INT,
	FOREIGN KEY (student_id) REFERENCES students(id)
);

-- 1:n

-- n:n

CREATE TABLE classes (
	class_id INT PRIMARY KEY AUTO_INCREMENT,
	course_number SMALLINT NOT NULL,
	course_name VARCHAR(40) NOT NULL,
	course_description VARCHAR(600),
	start_time VARCHAR(10),
	duration SMALLINT -- Limit for smallint is 2 bytes (32,000)
); 

CREATE TABLE students_classes (
	student_id INT NOT NULL,
	class_id INT NOT NULL,
	FOREIGN KEY (student_id) REFERENCES students(id),
	FOREIGN KEY (class_id) REFERENCES classes(class_id) 
);

INSERT INTO students (id, s_name, gpa, gender) VALUES 
	(1, "Seth", 4.00, "M"),
	(2, "Tim", 2.34, "M"),
	(3, "Belinda", 4.00, "F");

INSERT INTO classes (course_number, course_name, 
course_description, start_time, duration) VALUES
	(201, "early american lit", "novels no one else in the world reads.", "9:00 AM", 90),
	(305, "Java Fundamentals", "Week 2 of our bootcamp.", "11:00 AM", 60),
	(235, "Operating Systems", "why nerds use linux.", "3:00 pm", 90)

INSERT INTO students_classes (student_id, class_id) VALUES
	(1, 2),
	(1, 3),
	(2, 1),
	(2, 2),
	(2, 3),
	(3, 1),
	(3, 3)
	
INSERT INTO addresses (street_addr, city, region, postal_code, student_id) VALUES 
	("123 Dev Lane", "Sterling", "VA", "20170", 2),
	("456 Main Street", "Herndon" , "VA", "20170", 2),
	("678 Brilliant Road", "Chantilly", "VA", "20191", 1)

INSERT INTO students (id, s_name, gpa, gender, address)
	VALUES (1, "Seth", 4.00, "M", "123 Hopalong Lane"),
	(2, "Tim", 2.34, "M", "234 Developer Way"),
	(3, "Belinda", 4.00, "F", "345 LivingTheDream Circle");


-- JOINS -------------------------------------------------------------------

SELECT * FROM students INNER JOIN addresses ON student_id = id;

-- OUTER JOIN (FULL JOIN)
SELECT * FROM students LEFT JOIN addresses ON student_id = id;
UNION
SELECT * FROM students AS s RIGHT JOIN addresses ON student_id = s.id; -- Alias 's'.

-- Subqueries Join
SELECT * FROM (SELECT * FROM students 
	INNER JOIN students_classes ON students.id = students_classes.student_id)
	AS ssc INNER JOIN classes ON classes.class_id = ssc.class_id;


-- View
-- CREATE OR REPLACE VIEW student


INSERT INTO addresses (street_addr, city, region, postal_code, student_id) VALUES 
	("333 Lonley Mountain", "Sterling", "VA", "20170", null);

-- Other Stuff -------------------------------------------------------------

ALTER  TABLE students ADD COLUMN graduated BOOL;

TRUNCATE TABLE students;

INSERT INTO students (id, s_name, gpa, gender, address) VALUES 
	(1, "Seth", 4.00, "M", "123 Hopalong Lane"),
	(2, "Tim", 2.34, "M", "234 Developer Way"),
	(3, "Belinda", 4.00, "F", "345 LivingTheDream Circle");

UPDATE students SET graduated = TRUE;

SELECT s_name, gpa FROM students; 

SELECT * FROM students WHERE gpa > 3;

DELETE FROM students WHERE id = 1;

SELECT * FROM students;

-- Transaction Example (TCL)
BEGIN;
INSERT INTO students(id, gpa) VALUES (5, 3.45);
UPDATE students SET s_name = "kulsoom" WHERE id = 5;
UPDATE students SET address = "678 Developer Way" WHERE id = 5;
COMMIT;

BEGIN;
INSERT INTO students(id, gpa) VALUES (6, 3.45);
UPDATE students SET s_name = "kulsoom" WHERE id = 6;
UPDATE students SET address = "678 Developer Way" WHERE id = 6;
ROLLBACK;

DELETE FROM students WHERE id = 6

-- SCALAR FUNCTIONS

SELECT UPPER (s_name), id FROM students;

SELECT * FROM students WHERE s_name LIKE '%i%'; -- Has an 'I' in it.


-- AGGREGATE FUNCTIONS
SELECT AVG(gpa) FROM students;

SELECT MIN(gpa) FROM students;


-- SET OPERATIONS
SELECT s_name FROM students ORDER BY s_name ASC; -- DESC 