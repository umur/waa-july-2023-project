INSERT INTO `users` (`id`, `email`, `first_name`, `last_name`, `password`,
                     `active`, `deleted`, `city`, `street`, `zip`, `state`)
VALUES (1,'uinan@miu.edu','Umur','Inan',
        '$2a$10$oZpW1LsE9i.HoyWvUhjy/.xrNx/oPJmc8PefV9UGMjzrPVsN7JKdu', /* password */
        1, 0, 'Fairfield','1000 north 4th street','52557', 'Iowa'),
       (2,'dinomov@miu.edu','Dilshod','Inomov',
        '$2a$10$oZpW1LsE9i.HoyWvUhjy/.xrNx/oPJmc8PefV9UGMjzrPVsN7JKdu', 1, 0, 'Fairfield','1000 north 4th street','52557', 'Iowa'),
       (3,'admin@miu.edu','Admin','Admin',
        '$2a$10$oZpW1LsE9i.HoyWvUhjy/.xrNx/oPJmc8PefV9UGMjzrPVsN7JKdu', 1, 0, 'Fairfield','1000 north 4th street','52557', 'Iowa'),
       (4,'mikromov@miu.edu','Mirzokhidjon','Ikromov',
        '$2a$10$oZpW1LsE9i.HoyWvUhjy/.xrNx/oPJmc8PefV9UGMjzrPVsN7JKdu', 1, 0, 'Mountain View','1234 Levin Ave','94040', 'California'),
       (5,'john@miu.edu','John','Smith',
    '$2a$10$oZpW1LsE9i.HoyWvUhjy/.xrNx/oPJmc8PefV9UGMjzrPVsN7JKdu', 1, 0, 'Mountain View','1234 Levin Ave','94040', 'California');

INSERT INTO `faculties` (`id`, `title`, `salary`)
VALUES (1,'Assistant Professor of Computer Science',227000),
       (5,'Professor',1200000);

INSERT INTO `students` (`id`, `major`, `gpa`)
VALUES (2,'ComPro',4.0);

INSERT INTO `students` (`id`, `major`, `gpa`)
VALUES (4,'ComPro',4.0);

INSERT INTO `staffs` (`id`, `title`)
VALUES (3,'System administrator');

INSERT INTO `role` (`id`, `role`)
VALUES (1,'ADMIN'), (2,'FACULTY'), (3,'STUDENT');

INSERT INTO user_roles (user_id, roles_id)
VALUES (1, 2);
INSERT INTO user_roles (user_id, roles_id)
VALUES (2, 3);
INSERT INTO user_roles (user_id, roles_id)
VALUES (3, 1);
INSERT INTO user_roles (user_id, roles_id)
VALUES (4, 3);
INSERT INTO user_roles (user_id, roles_id)
VALUES (5, 2);

INSERT INTO job_advertisement (id, is_deleted, date_created, faculty_id, benefits, city, company_name, description, state)
VALUES (1, 0, '2023-07-11 02:53:50', 1, "Unlimited PTO", "Austin", "Apple", "Looking for Java Software Engineers", "Texas");

INSERT INTO tag (id, deleted, name)
VALUES (1, 0, "Java");

INSERT INTO job_advertisement_tags (job_advertisement_id, tags_id)
VALUES (1, 1);