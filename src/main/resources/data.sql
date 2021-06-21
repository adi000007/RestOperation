


DROP TABLE IF EXISTS Employee;

CREATE TABLE Employee (
                              id INT AUTO_INCREMENT  PRIMARY KEY,
                              emp_id number NOT NULL,
                              emp_name VARCHAR(250) NOT NULL,
                              salary number DEFAULT NULL
);

INSERT INTO Employee VALUES ( (1,'aditya',1000),(2,'adityaa',2000),(3,'adityaaa',3000),(4,'adityaaaa',4000), ) ;