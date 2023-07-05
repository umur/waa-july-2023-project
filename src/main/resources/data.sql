--Insert data into Address table
INSERT INTO cs545_WAA_project_db.addresses (city, state, street, zip_code)
VALUES
    ('New York', 'NY', '123 Main Street', '10001'),
    ('Los Angeles', 'CA', '456 Elm Street', '90001'),
    ('Chicago', 'IL', '789 Oak Avenue', '60601'),
    ('Houston', 'TX', '321 Pine Road', '77001');

--Insert data into Users table
INSERT INTO cs545_WAA_project_db.users (is_active, user_type, email, password, username)
VALUES
    (1, 'Faculty', 'faculty@example.com', 'password123', 'faculty123'),
    (1, 'Student', 'student1@example.com', 'password456', 'student1'),
    (1, 'Student', 'student2@example.com', 'password789', 'student2'),
    (1, 'Student', 'student3@example.com', 'passwordabc', 'student3');

--Insert data into Faculties table
INSERT INTO cs545_WAA_project_db.faculties (id, city, major, name, state)
VALUES
    (1, 'New York', 'Computer Science', 'John Doe', 'NY'),
    (2, 'Los Angeles', 'Mathematics', 'Jane Smith', 'CA'),
    (3, 'Chicago', 'Physics', 'Michael Johnson', 'IL'),
    (4, 'Houston', 'Biology', 'Sarah Wilson', 'TX');

--Insert data into Password Reset Tokens table
INSERT INTO cs545_WAA_project_db.password_reset_tokens (expiry_date, user_id, token)
VALUES
    ('2023-07-03 12:00:00', 2, 'abc123xyz'),
    ('2023-07-04 14:30:00', 3, 'def456pqr'),
    ('2023-07-05 10:15:00', 4, 'ghi789stu'),
    ('2023-07-06 09:45:00', 2, 'jkl012vwx');

-- Insert data into Students table
INSERT INTO cs545_WAA_project_db.students (address_id,id, city, major, name, state, cv)
VALUES
    (1, 1, 'New York', 'Computer Science', 'Alice Johnson', 'NY', 'Sample CV for Alice Johnson'),
    (2, 2, 'Los Angeles', 'Mathematics', 'Bob Smith', 'CA', 'Sample CV for Bob Smith'),
    (3, 3, 'Chicago', 'Physics', 'Charlie Brown', 'IL', 'Sample CV for Charlie Brown'),
    (4, 4, 'Houston', 'Biology', 'David Wilson', 'TX', 'Sample CV for David Wilson');

-- -- Insert data into Comments table
INSERT INTO cs545_WAA_project_db.comments (date_created, faculty_id, student_id, content)
VALUES
    ('2023-07-01 09:30:00', 1, 1, 'Great work!'),
    ('2023-07-02 11:45:00', 2, 2, 'Keep it up!'),
    ('2023-07-03 14:20:00', 3, 3, 'Impressive presentation.'),
    ('2023-07-03 16:30:00', 1, 4, 'Well done!');


-- Insert data into Job Advertisements table
INSERT INTO cs545_WAA_project_db.job_advertisements (is_active, date_created, date_updated, location_id, student_id, company_name, description, title)
VALUES
    (1, '2023-06-30 10:00:00', '2023-06-30 12:30:00', 1, 1, 'ABC Company', 'Job description for ABC Company', 'Software Engineer'),
    (1, '2023-07-01 14:45:00', '2023-07-01 16:15:00', 2, 2, 'XYZ Corporation', 'Job description for XYZ Corporation', 'Data Analyst'),
    (1, '2023-07-02 09:15:00', '2023-07-02 11:30:00', 3, 4, '123 Industries', 'Job description for 123 Industries', 'Research Scientist'),
    (1, '2023-07-03 13:00:00', '2023-07-03 15:45:00', 4, 3, 'Acme Corporation', 'Job description for Acme Corporation', 'Marketing Coordinator');

-- Insert data into Job Advertisement Tags table
INSERT INTO cs545_WAA_project_db.job_advertisement_tags (job_advertisement_id, tag)
VALUES
    ( 1,'Java'),
    ( 2,'SQL'),
    (3,'Python'),
    (4,'Marketing');



-- Insert data into Job Experiences table
INSERT INTO cs545_WAA_project_db.job_experiences (student_id)
VALUES
    (2),
    (3),
    (4),
    (1);

--Insert data into Job Files table
INSERT INTO cs545_WAA_project_db.job_files (job_advertisement_id, file_name)
VALUES
    (1, 'resume.pdf'),
    (2, 'cover_letter.doc'),
    (3, 'portfolio.pdf'),
    (4, 'references.doc');
