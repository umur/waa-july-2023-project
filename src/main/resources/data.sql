

INSERT IGNORE users (id, email, first_name, last_name, password)
VALUES (1, 'student1@miu.edu', 'student', 'one', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); -- 123
INSERT IGNORE users (id, email, first_name, last_name, password)
VALUES (2, 'student2@miu.edu', 'student', 'two', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); -- 123
INSERT IGNORE users (id, email, first_name, last_name, password)
VALUES (3, 'admin@miu.edu', 'Dean', 'Altarawneh', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); -- 123
INSERT IGNORE users (id, email, first_name, last_name, password)
VALUES (4, 'employee1@miu.edu', 'Employee', 'one', '$2a$12$IKEQb00u5QpZMx4v5zMweu.3wrq0pS7XLCHO4yHZ.BW/yvWu1feo2'); -- 123



INSERT IGNORE role (id, role)
VALUES (1, 'STUDENT');
INSERT IGNORE role (id, role)
VALUES (2, 'FACULTY');
INSERT IGNORE role (id, role)
VALUES (3, 'ADMIN');


INSERT IGNORE users_roles (user_id, roles_id)
VALUES (1, 1);
INSERT IGNORE users_roles (user_id, roles_id)
VALUES (2, 1);
INSERT IGNORE users_roles (user_id, roles_id)
VALUES (3, 3);
INSERT IGNORE users_roles (user_id, roles_id)
VALUES (4, 2);


