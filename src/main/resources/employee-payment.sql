CREATE DATABASE workout;

CREATE TABLE employee (
                          id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                          name VARCHAR(64)
);

CREATE TABLE payment (
                            id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                            d DATE,
                            amount DECIMAL(10,2) CHECK (amount >= 0),
                            employee_id INT REFERENCES employee(id)
);

--ALTER TABLE payments RENAME TO payment;
-- выбрать из з
ALTER TABLE payment RENAME COLUMN d to created_data;

SELECT * from employee;
SELECT * from payment;

INSERT INTO employee (name)
VALUES ('Sergei'),
       ('Maxim'),
       ('Michael');

INSERT INTO payment (created_data, employee_id, amount)
VALUES ('2023-11-30', 1, 10.99),
       ('2023-11-30', 2, 20),
       ('2023-12-01', 1, 100.20),
       ('2023-12-06', 1, 120000);


DELETE FROM payment; -- WHERE employee_id = 3;

SELECT e.name, p.amount FROM employee e
CROSS JOIN payment p ;

SELECT e.name, SUM(p.amount)  as total_sum FROM employee e
JOIN payment p ON e.id = p.employee_id
GROUP BY e.id;

SELECT e.name, SUM(p.amount) AS total_amount FROM employee e
JOIN payment p ON  e.id = p.employee_id
GROUP BY e.id
HAVING SUM(p.amount) > 1000;


SELECT e.name, SUM(p.amount) AS total_amount FROM employee e
LEFT JOIN payment p ON  e.id = p.employee_id
GROUP BY e.id;

SELECT e.name FROM employee e;
