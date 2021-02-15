CREATE TABLE new_student (
student_ID INT PRIMARY KEY,
fullname VARCHAR(100),
admisson_year INT,
group_ID  INT
);

INSERT INTO new_student VALUES(1, "Ivan Ivanov", 2020, 202001);
INSERT INTO new_student VALUES(2, "Ivana Ivanova", 2019, 201902);
INSERT INTO new_student VALUES(3, "Fedyr Fedorov", 2018, 201803);
SELECT *FROM new_student;


CREATE TABLE student_group(
    group_ID INT PRIMARY KEY,
    student_group VARCHAR (100) NULL
);

INSERT INTO student_group VALUES(202001, "History"), (201902, "Biology"), (201803, "History");
SELECT *FROM student_group;

CREATE TABLE student_points(
    st_point_ID INT PRIMARY KEY,
    st_lesson_ID INT,
    student_ID INT,
    point INT
);

INSERT INTO student_points VALUES (1000, 10, 3, 100), (1001, 11, 2, 90), (1002, 12, 1, 85);
SELECT *FROM student_points;

CREATE TABLE student_lessons(
    st_lesson_ID INT PRIMARY KEY,
    lesson VARCHAR (500),
    teacher_ID INT,
    semester INT NULL,
    YEAR INT NULL
);

INSERT INTO student_lessons VALUES (10, "History",1234, 1, 2020), (11,"Biology", 1235, 1, 2019), (12,"History", 1236, 1, 2018);
SELECT *FROM student_lessons;

CREATE TABLE new_teacher(
    teacher_ID INT PRIMARY KEY,
    fullname VARCHAR (100),
    department_ID INT
);

INSERT INTO new_teacher VALUES(1234,"Plutarch", 300),(1235, "Avestan",200),(1236, "Aristotle", 301);
SELECT *FROM new_teacher;

CREATE TABLE teacher_department(
    department_ID INT PRIMARY KEY,
    department_name VARCHAR (500),
    dep_head_fullname VARCHAR(100)
);

INSERT INTO teacher_department VALUES (300, "Greek History","Herodotus"),(200, "Botany","Theophrastus"),(301, "History", "Thucydides");
SELECT *FROM teacher_department;

ALTER TABLE student_points ADD FOREIGN KEY (student_ID) REFERENCES new_student(student_ID);
ALTER TABLE new_student ADD FOREIGN KEY (group_ID)  REFERENCES student_group(group_ID);
ALTER TABLE student_points ADD FOREIGN KEY (st_lesson_ID) REFERENCES student_lessons(st_lesson_ID);
ALTER TABLE  student_lessons ADD FOREIGN KEY(teacher_ID) REFERENCES new_teacher(teacher_ID);
ALTER TABLE new_teacher ADD FOREIGN KEY(department_ID) REFERENCES teacher_department(department_ID);

SELECT *FROM new_student;