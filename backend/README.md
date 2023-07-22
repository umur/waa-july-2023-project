admin user
username:admin@miu.edu, password:password

faculty
username:john@miu.edu  password:password


to generate bunch of students, make get request to this endpoint

/uaa/generateStudents




## Alumni Management Portal
 
Alumni Tracking System is an online-based application that helps to tracking of college graduates. The project aims to improve current tracking procedure of college graduate and providing alumni data to college faculties. It aims to developing a web portal which will be useful for the college to monitor the alumni and for the alumni to update their current status about the job activities.

Create dashboard pages for students and faculty:
- Display the last 10 job advertisements. 
- Display 10 most recently applied job advertisements.
- Display charts.
- Add more features as you see fit.

####  Functional  Requirements
--- 
* Faculty/Students can register to the system.
* Faculty/Students can only edit their own profile information.
* Students can add job advertisements.
	* Can upload pictures/files of the job.
	* Optional: Use cloud services like Amazon S3 or Google Cloud Storage.
* Students can only edit their own job advertisements.
* Students can apply to the jobs.
	* Student's CV will be also visible to owners of the job advertisements that the student has applied.
* Students and Faculty can filter job advertisements:
	* by tags.
	* by state.
	* by city
	* by companyName.
* Faculty can filter students:
	* by state.
	* by city.
	* by major.
	* by name.
	* by student id.
* Auto-complete tags while typing.
* Faculty can write comments on students.
	* Only faculty can see the comments.
* Students can add their professional job experiences.
*  Admin can Activate/Deactivate students and faculty.
* Admin can reset passwords.
* Students and faculty can reset their password.
	* Users should follow a password reset link.
* Use [ECharts](https://echarts.apache.org/en/index.html) to create live charts for dashboards:
	* Number of job advertisements per location. 
	* Number of students per state.
	* Number of students per city. (User should select the state.)
	* Tags.
	* Tags with location. 
	* Average time spent to find a job per gpa range.
	* Add at least 4 more charts as you see fit.
*   All delete operations should be a soft deletion.
* Log all user activities on the system.
	* Optional: Log data before/after for update operations.
* Limit login attempts. If a user try to login with an invalid password more than 5 times, the system will lock the user and make it unable to login for 15 minutes.


#### Technical Details
---
* Use Java and Spring Boot framework for the backend project.
* Use React framework for the frontend project.
* Use n-tier software architecture model.
* Populate your database with dummy data using `data.sql`.
	* Prepare your dummy data for testing and presentation.
* If necessary, change isolation levels.
* If necessary, change Fetch mode.


#### Submission
---
* Submit a detailed project plan for your daily performance (day/task/time) and submit it with your code.
* Fork this repository and push your changes.
* Once you finished your project, send a Pull Request. (Send only one Pull Request once you finish the assignment.)
* Project will be evaluated based on your code quality. It is possible that I will need to schedule meetings with some students about their source-code.

#### Important Notes
---
* You are not allowed to share codes with your classmates. If detected, you will get NC.
 
* Remember to respect the code honor submission policy. All written code must be original. Presenting something as one’s own work when it came from another source is plagiarism and is forbidden.
    
* Plagiarism is a very serious thing in all American academic institutions and is guarded against vigilantly by every professor.
 

