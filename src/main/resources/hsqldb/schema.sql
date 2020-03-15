DROP TABLE students IF EXISTS;

CREATE TABLE students (
  id         INTEGER IDENTITY PRIMARY KEY,
  name       VARCHAR(30),
  gender     VARCHAR(20),
  birthday   VARCHAR(80),
  native_place VARCHAR(80),
  major      VARCHAR(20)
);
CREATE INDEX student_name ON students (name);




