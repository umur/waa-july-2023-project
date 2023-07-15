--DO $$
--BEGIN
--	  IF NOT EXISTS (SELECT * FROM role  WHERE name = 'admin') THEN
--	   INSERT INTO role (id, name) VALUES (1, 'admin'), (2, 'faculty'), (3, 'student');
--	   SELECT SETVAL('role_seq',3);
--	  END IF;
--END $$



INSERT INTO role (id, name) VALUES (1, 'admin');
INSERT INTO role (id, name) VALUES (2, 'faculty');
INSERT INTO role (id, name) VALUES (3, 'student');

SELECT SETVAL('role_seq',3);