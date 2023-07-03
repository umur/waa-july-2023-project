
INSERT INTO `address` (`id`, `city`, `street`, `zip`, `state`, `deleted`)
VALUES (1,'Fairfield','1000 north 4th street','52557', 'Iowa', 0),
       (2,'Fairfield','1000 north 4th street','52557', 'Iowa', 0),
       (3,'Fairfield','1000 north 4th street','52557', 'Iowa', 0);

INSERT INTO `user` (`id`, `address_id`, `email`, `first_name`, `last_name`, `password`,
                    `active`, `deleted`)
VALUES (1,1,'uinan@miu.edu','Umur','Inan',
        '$2a$10$oZpW1LsE9i.HoyWvUhjy/.xrNx/oPJmc8PefV9UGMjzrPVsN7JKdu', /* password */
        1, 0),
       (2,2,'dinomov@miu.edu','Dilshod','Inomov',
        '$2a$10$oZpW1LsE9i.HoyWvUhjy/.xrNx/oPJmc8PefV9UGMjzrPVsN7JKdu', 1, 0),
       (3,3,'admin@miu.edu','Admin','Admin',
        '$2a$10$oZpW1LsE9i.HoyWvUhjy/.xrNx/oPJmc8PefV9UGMjzrPVsN7JKdu', 1, 0);

INSERT INTO `faculty` (`id`, `title`, `salary`)
VALUES (1,'Assistant Professor of Computer Science',227000);

INSERT INTO `student` (`id`, `major`, `gpa`)
VALUES (2,'ComPro',4.0);

INSERT INTO `staff` (`id`, `title`)
VALUES (3,'System administrator');

INSERT INTO `role` (`id`, `role`)
VALUES (1,'ADMIN'), (2,'FACULTY'), (3,'STUDENT');

INSERT INTO user_roles (user_id, roles_id)
VALUES (1, 2);
INSERT INTO user_roles (user_id, roles_id)
VALUES (2, 3);
INSERT INTO user_roles (user_id, roles_id)
VALUES (3, 1);
