INSERT IGNORE INTO universitymember(id, email, role)
VALUES(1, 'student1@miu.edu', 'STUDENT');
INSERT IGNORE INTO universitymember(id, email, role)
VALUES(2, 'student2@miu.edu', 'STUDENT');
INSERT IGNORE INTO universitymember(id, email, role)
VALUES(3, 'admin@miu.edu', 'ADMIN');
INSERT IGNORE INTO universitymember(id, email, role)
VALUES(4, 'employee1@miu.edu', 'FACULTY');
INSERT IGNORE INTO universitymember(id, email, role)
VALUES(5, 'student3@miu.edu', 'STUDENT');


INSERT IGNORE users (id, email, first_name, last_name, password)
VALUES (1, 'student1@miu.edu', 'student', 'one', '$2a$10$ssIMs0xJ5lSHrfiHJfQJMewmc7TD3rmsdE9xprZJFamGRsYSuc82S'); -- 123
INSERT IGNORE users (id, email, first_name, last_name, password)
VALUES (2, 'student2@miu.edu', 'student', 'two', '$2a$10$ssIMs0xJ5lSHrfiHJfQJMewmc7TD3rmsdE9xprZJFamGRsYSuc82S'); -- 123
INSERT IGNORE users (id, email, first_name, last_name, password)
VALUES (3, 'admin@miu.edu', 'Dean', 'Altarawneh', '$2a$10$ssIMs0xJ5lSHrfiHJfQJMewmc7TD3rmsdE9xprZJFamGRsYSuc82S'); -- 123
INSERT IGNORE users (id, email, first_name, last_name, password)
VALUES (4, 'employee1@miu.edu', 'Employee', 'one', '$2a$10$ssIMs0xJ5lSHrfiHJfQJMewmc7TD3rmsdE9xprZJFamGRsYSuc82S'); -- 123



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


