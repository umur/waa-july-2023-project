import react from 'react';
import axios from 'axios';
import ReactDOM from 'react-dom';
import {useState, useEffect} from 'react';
import Editprofile from '../facultyMethods/EditProfile';
import Student from './Student';
import Register from '../facultyMethods/RegisterToSystem';
import ResetPassword from '../facultyMethods/ResetPassword';
import WriteComment from '../facultyMethods/WriteComment';
import FacultyList from '../facultyMethods/FacultyList';
import Filter from '../facultyMethods/Filter';
import FilterJob from '../facultyMethods/FilterJob';
import StudentList from '../studentmethods/StudentList';
import { BrowserRouter as Router, Routes} from 'react-router-dom';
import { Route, useNavigate } from 'react-router-dom';
import Edit from '../facultyMethods/EditProfile';


export default function Faculty() {

    const job = [
        {jobId: 1, jobTitle: 'Software Engineer', jobDescription: 'Developing Software', jobLocation: 'Colombo', company: 'Google', jobSalary: '$ 120,000', postedDate: '2021-09-20'},
        { jobId: 2, jobTitle: 'Software Engineer', jobDescription: 'Developing Software', jobLocation: 'Maryland', company: 'Amazon', jobSalary: '$ 110,000', postedDate: '2021-09-20'},
        { jobId: 3, jobTitle: 'Accounting', jobDescription: 'Developing Software', jobLocation: 'Remote', company: 'Infosys', jobSalary: '$ 100,000', postedDate: '2021-09-20'},
        { jobId: 4, jobTitle: 'FrontEnd Developer', jobDescription: 'Developing Software', jobLocation: 'Remote', company: 'Coginizant', jobSalary: '$ 115,000', postedDate: '2021-09-20'},
        { jobId: 5, jobTitle: 'Back End Developer', jobDescription: 'Developing Software', jobLocation: 'Dallas', company: 'Infosys', jobSalary: '$ 100,000', postedDate: '2021-09-20'},
        { jobId: 6, jobTitle: 'Full Stack', jobDescription: 'Developing Software', jobLocation: 'Washington', company: 'TSS', jobSalary: '$ 130,000', postedDate: '2021-09-20'},
        { jobId: 7, jobTitle: 'Software Engineer', jobDescription: 'Developing Software', jobLocation: 'Chicago', company: 'Apple', jobSalary: '$ 140,000', postedDate: '2021-09-20'},
]

const student = [
    {name:"Andy", state: "Iowa", city:"Desmoines", major:"BcSC", CV:"cv"},
    {name:"Noa", state: "Michigan", city:"Detroit", major:"Law", CV:"cv"},
    {name:"Nolan", state: "Illinois", city:"Chicago", major:"Civil Engineering", CV:"cv"}

]

const [jobs, setJobs]= useState(job);
const [showTable, setShowTable]= useState(true);
const [faculty, setFaculty]= useState([]);
const navigate = useNavigate();

const [students, getStudents]=useState(student);

useEffect(() => {
    axios
      .get("http://localhost:8080/student/all/jobs")
      .then((response) => {
        setJobs(response.data);
        console.log(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  }, [students]);

  
const handleUpdate = (updatedJob) => {
    const updatedJobs = faculty.map((job) =>
      job.id === updatedJob.id ? updatedJob : job
    );
    setFaculty(updatedJobs);
    setShowTable(true);
    // Send the updated job data to the server for persistence
    axios
      .put(`http://localhost:8080/faculty/update`, updatedJob)
      .then((response) => {
        console.log(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  };
const editBtn= ()=>{
    console.log("Add profile Button Clicked");

     navigate('/editprofile');
}


const filterSt=()=>{
    console.log("Add Student Button Clicked");
navigate('/filter-student');  
}
const filterJob=()=>{
    console.log("Add Job Button Clicked");
    navigate('/filter-job');}

const registerToSystem =()=>{
navigate('/register');
}

const resetPassword=()=>{
    console.log("Add Student Button Clicked");
    navigate('/resetpassword');
}

const writeComment=()=>{
    console.log("Add Student Button Clicked");
    navigate('/writecomment'); 
}
const btnUpdate = () => {
    console.log("Update Button Clicked");
    navigate('/editjob');
    
  

    };



return (
    <div>
        
               
                
        <nav className="navbar navbar-expand-lg bg-body-tertiary">

            <div className='container'>
               

                
                <button type="button" className="btn btn-primary" onClick={() => editBtn(job.id)}>Edit Profile</button>
                <button type="button" className="btn btn-primary" onClick={filterSt}>Filter Student</button>
                <button type="button" className="btn btn-primary" onClick={filterJob}>Filter Job</button>
                <button type="button" className="btn btn-primary" onClick={registerToSystem}>Register To System</button>
                <button type="button" className="btn btn-primary" onClick={resetPassword}>Reset Password</button>
                <button type="button" className="btn btn-primary" onClick={writeComment}>Write Comment</button>

                </div>
                </nav>
                
     <h1>Welcome To Faculty Page</h1>
        <br/>
        <div className="container">
            <div className="row">
                <table className="table table-striped table-bordered">
                    <thead>
                        <tr>
                        <th>Job ID</th>
                        <th>Job Title</th>
                        <th>Job Description</th>
                        <th>Job Loction</th>
                        <th>Company</th>
                        <th>Job Salary</th>
                        <th>Posted Date</th>
                        <th>Actions</th>
                        </tr>
                    
                        </thead>
                        <tbody>
                            {
                                jobs.map(
                                    job =>
                                    <tr key={job.id}>
                                        <td>{job.id}</td>
                                        <td>{job.jobTitle}</td>
                                        <td>{job.jobDescription}</td>
                                        <td>{job.jobLocation}</td>
                                        <td>{job.copanyName}</td>
                                        <td>{job.jobSalary}</td>
                                        <td>{job.postedDate}</td>
                                        <td>
                                            <button style={{margin:'10px'}} className="btn btn-info" onClick={btnUpdate}>Update</button>
                                            <button className="btn btn-danger">Delete</button>
                                        </td>

                                    </tr>
                                )

                            }
                               
                            
                        </tbody>
                    </table>
                    

            </div>  
        </div>

<br/>
<br/>


        </div>
    );
    }   