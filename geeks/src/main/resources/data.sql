

INSERT INTO user (name, image, username, password, email, state, city, major, role, is_Active, cv, is_Deleted)
VALUES
('John Doe', 'image_url', 'johndoe', 'password123', 'johndoe@example.com', 'California', 'Los Angeles', 'Computer Science', 'USER', true, 'cv_url', false),
('Jane Smith', 'image_url', 'janesmith', 'password456', 'janesmith@example.com', 'New York', 'New York City', 'Business Administration', 'USER', true, 'cv_url', false),
('Mike Johnson', 'image_url', 'mikejohnson', 'password789', 'mikejohnson@example.com', 'Texas', 'Austin', 'Engineering', 'USER', true, 'cv_url', false),
('Sarah Johnson', 'image_url', 'sarahjohnson', 'password123', 'sarahjohnson@example.com', 'Florida', 'Miami', 'Marketing', 'USER', true, 'cv_url', false),
('Michael Smith', 'image_url', 'michaelsmith', 'password456', 'michaelsmith@example.com', 'California', 'San Francisco', 'Art', 'USER', true, 'cv_url', false),
('Emily Davis', 'image_url', 'emilydavis', 'password789', 'emilydavis@example.com', 'Texas', 'Houston', 'Psychology', 'USER', true, 'cv_url', false),
('Daniel Wilson', 'image_url', 'danielwilson', 'password123', 'danielwilson@example.com', 'New York', 'Albany', 'Biology', 'USER', true, 'cv_url', false),
('Olivia Thompson', 'image_url', 'oliviathompson', 'password456', 'oliviathompson@example.com', 'Florida', 'Orlando', 'Education', 'USER', true, 'cv_url', false),
('Andrew Miller', 'image_url', 'andrewmiller', 'password789', 'andrewmiller@example.com', 'California', 'San Diego', 'Finance', 'USER', true, 'cv_url', false),
('Sophia Davis', 'image_url', 'sophiadavis', 'password123', 'sophiadavis@example.com', 'Texas', 'Dallas', 'Music', 'USER', true, 'cv_url', false);



INSERT INTO experience (company_Name, role, date_Started, date_Ended, description, user_id)
VALUES
('ABC Company', 'Software Engineer', '2020-01-01', '2022-12-31', 'Worked on developing web applications', 1),
('XYZ Corporation', 'Data Analyst', '2019-05-01', '2021-09-30', 'Performed data analysis and created reports', 1),
('123 Industries', 'Project Manager', '2018-03-15', '2020-06-30', 'Managed multiple projects and teams', 2),
('DEF Corporation', 'Software Developer', '2019-07-01', '2021-12-31', 'Developed web applications using Java and Spring', 2),
('GHI Technologies', 'Database Administrator', '2020-02-15', '2022-08-31', 'Managed and optimized database systems', 3),
('JKL Solutions', 'Business Analyst', '2018-09-01', '2021-03-31', 'Analyzed business requirements and proposed solutions', 3),
('MNO Enterprises', 'UX Designer', '2017-06-01', '2019-12-31', 'Created user-centered designs for web and mobile applications', 4),
('PQR Company', 'IT Support Specialist', '2019-01-15', '2021-06-30', 'Provided technical support and troubleshooting for software and hardware', 4),
('STU Innovations', 'Software Engineer', '2018-03-01', '2020-09-30', 'Developed and maintained backend systems using Python and Django', 5),
('VWX Corporation', 'Product Manager', '2017-08-15', '2019-12-31', 'Managed product roadmap and coordinated cross-functional teams', 6);


INSERT INTO log (date_Time, description, user_id)
VALUES
('2022-01-01 10:30:00', 'User logged in', 1),
('2022-01-02 14:45:00', 'User updated profile information', 1),
('2022-01-03 09:15:00', 'User performed a search', 2),
('2022-01-04 16:20:00', 'User created a new entry', 3),
('2022-01-05 12:00:00', 'User deleted a record', 3),
('2022-01-06 08:30:00', 'User accessed a restricted resource', 4),
('2022-01-07 13:10:00', 'User performed an action', 5);


INSERT INTO advertisement (company_Name, title, state, city, tag, date, start_Date, salary, description, is_Deleted, creator_id)
VALUES
('ABC Company', 'Software Developer', 'California', 'San Francisco', 'IT', '2022-01-01', '2022-02-01', 75000.00, 'Seeking experienced software developers for web application development.', false, 1),
('XYZ Corporation', 'Data Analyst', 'New York', 'New York City', 'Data Science', '2022-01-02', '2022-03-01', 80000.00, 'Looking for skilled data analysts with experience in statistical analysis and data visualization.', false, 2),
('123 Industries', 'Project Manager', 'Texas', 'Austin', 'Management', '2022-01-03', '2022-02-15', 90000.00, 'Hiring project managers to oversee and coordinate multiple projects.', false, 3),
('DEF Company', 'UX Designer', 'California', 'Los Angeles', 'Design', '2022-01-04', '2022-03-15', 70000.00, 'Seeking creative UX designers with a strong portfolio and user-centered design skills.', false, 4),
('GHI Corporation', 'Marketing Specialist', 'Florida', 'Miami', 'Marketing', '2022-01-05', '2022-04-01', 65000.00, 'Looking for marketing specialists with experience in digital marketing and campaign management.', false, 5),
('JKL Solutions', 'Business Analyst', 'Texas', 'Dallas', 'Business Analysis', '2022-01-06', '2022-02-28', 85000.00, 'Hiring business analysts to analyze business processes and propose improvements.', false, 6),
('MNO Enterprises', 'Sales Representative', 'New York', 'Albany', 'Sales', '2022-01-07', '2022-03-15', 60000.00, 'Looking for motivated sales representatives to drive sales and meet targets.', false, 7);


INSERT INTO comment (date_And_Time, comment, is_Deleted, comment_Giver_id, comment_Receiver_id)
VALUES
('2022-01-01 10:30:00', 'Great work!', false, 1, 2),
('2022-01-02 14:45:00', 'I really enjoyed reading this.', false, 3, 1),
('2022-01-03 09:15:00', 'Nice job!', false, 2, 3),
('2022-01-04 16:20:00', 'Very informative.', false, 4, 1),
('2022-01-05 12:00:00', 'I have a question.', false, 5, 3),
('2022-01-06 08:30:00', 'Well done!', false, 2, 4),
('2022-01-07 13:10:00', 'Keep up the good work!', false, 3, 5);


insert into application (`advertisement_id`, `student_id`)
values(1,2),
      (1, 2),
      (1, 3),
      (1, 4),
      (2, 4),
      (2, 5),
      (4, 2),
      (4, 5);


