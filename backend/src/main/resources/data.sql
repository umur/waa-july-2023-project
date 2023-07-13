INSERT IGNORE INTO universitymember(id, email, role, create_date_time, update_date_time, version)
VALUES(1, 'student1@miu.edu', 'STUDENT', now(), now(), 1);
INSERT IGNORE INTO universitymember(id, email, role, create_date_time, update_date_time, version)
VALUES(2, 'student2@miu.edu', 'STUDENT', now(), now(), 1);
INSERT IGNORE INTO universitymember(id, email, role, create_date_time, update_date_time, version)
VALUES(3, 'admin@miu.edu', 'ADMIN', now(), now(), 1);
INSERT IGNORE INTO universitymember(id, email, role, create_date_time, update_date_time, version)
VALUES(4, 'employee1@miu.edu', 'FACULTY', now(), now(), 1);
INSERT IGNORE INTO universitymember(id, email, role, create_date_time, update_date_time, version)
VALUES(5, 'student3@miu.edu', 'STUDENT', now(), now(), 1);


INSERT IGNORE users (id, email, first_name, last_name, password, city, state, major, enabled, create_date_time, update_date_time, version)
VALUES (1, 'student1@miu.edu', 'student', 'one', '$2a$10$ssIMs0xJ5lSHrfiHJfQJMewmc7TD3rmsdE9xprZJFamGRsYSuc82S', 'Fairfield', 'Iowa', 'Computer Science', 1, now(), now(), 1); -- 123
INSERT IGNORE users (id, email, first_name, last_name, password, city, state, major, enabled, create_date_time, update_date_time, version)
VALUES (2, 'student2@miu.edu', 'student', 'two', '$2a$10$ssIMs0xJ5lSHrfiHJfQJMewmc7TD3rmsdE9xprZJFamGRsYSuc82S', 'Fairfield', 'Iowa', 'Computer Science', 1, now(), now(), 1); -- 123
INSERT IGNORE users (id, email, first_name, last_name, password, city, state, major, enabled, create_date_time, update_date_time, version)
VALUES (3, 'admin@miu.edu', 'Dean', 'Altarawneh', '$2a$10$ssIMs0xJ5lSHrfiHJfQJMewmc7TD3rmsdE9xprZJFamGRsYSuc82S', 'Fairfield', 'Iowa', 'Computer Science', 1, now(), now(), 1); -- 123
INSERT IGNORE users (id, email, first_name, last_name, password, city, state, major, enabled, create_date_time, update_date_time, version)
VALUES (4, 'employee1@miu.edu', 'Employee', 'one', '$2a$10$ssIMs0xJ5lSHrfiHJfQJMewmc7TD3rmsdE9xprZJFamGRsYSuc82S', 'Fairfield', 'Iowa', 'Computer Science', 1, now(), now(), 1); -- 123



INSERT IGNORE roles (id, name, create_date_time, update_date_time, version)
VALUES (1, 'STUDENT', now(), now(), 1);
INSERT IGNORE roles (id, name, create_date_time, update_date_time, version)
VALUES (2, 'FACULTY', now(), now(), 1);
INSERT IGNORE roles (id, name, create_date_time, update_date_time, version)
VALUES (3, 'ADMIN', now(), now(), 1);

INSERT IGNORE users_roles (user_id, roles_id)
VALUES (1, 1);
INSERT IGNORE users_roles (user_id, roles_id)
VALUES (2, 1);
INSERT IGNORE users_roles (user_id, roles_id)
VALUES (3, 3);
INSERT IGNORE users_roles (user_id, roles_id)
VALUES (4, 2);

