import { useState, useEffect } from 'react';
import axios from 'axios';

export default function Edit({ job, handleUpdate, redirectToTable }) {
  const style = {
    margin: 75,
  };
  const [jobs, setJobs] = useState([]);

  


  const [jobTitle, setJobTitle] = useState('');
  const [jobDescription, setJobDescription] = useState('');
  const [jobLocation, setJobLocation] = useState('');
  const [copanyName, setCopanyName] = useState('');
  const [jobSalary, setJobSalary] = useState('');
  const [postedDate, setPostedDate] = useState('');
  

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
  }, []);
    

  const handleSubmit = (e) => {
    e.preventDefault();
    const updatedJob = {
      jobTitle,
      jobDescription,
      jobLocation,
      copanyName,
      jobSalary,
      postedDate,


    };
    handleUpdate(updatedJob);
    redirectToTable();
  };

  const handleJobTitleChange = (e) => {
    setJobTitle(e.target.value);
  };
  const handleJobDescriptionChange = (e) => {
    setJobDescription(e.target.value);
  };
  const handleJobLocationChange = (e) => {
    setJobLocation(e.target.value);
  };
  const handleCompanyChange = (e) => {
   setCopanyName(e.target.value);
  };
  const handleJobSalaryChange = (e) => {
    setJobSalary(e.target.value);
  };
  const handlePostedDateChange = (e) => {
    setPostedDate(e.target.value);
  };

  return (
    <div>
      <h1>Edit Job</h1>
      <fieldset style={style}>
        <form onSubmit={handleSubmit}>
          <div className="form-group">
            <label>Job Title</label>
            <input
              type="text"
              className="form-control"
              placeholder="Enter Job Title"
              value={jobTitle}
              onChange={handleJobTitleChange}
            />
            <label>Job Description</label>
            <input
              type="text"
              className="form-control"
              placeholder="Enter Job Description"
              value={jobDescription}
              onChange={handleJobDescriptionChange}
            />
            <label>Job Location</label>
            <input
              type="text"
              className="form-control"
              placeholder="Enter Job Location"
              value={jobLocation}
              onChange={handleJobLocationChange}
            />
            <label>Company</label>
            <input
              type="text"
              className="form-control"
              placeholder="Enter Company"
              value={copanyName}
              onChange={handleCompanyChange}
            />
            <label>Job Salary</label>
            <input
              type="text"
              className="form-control"
              placeholder="Enter Job Salary"
              value={jobSalary}
              onChange={handleJobSalaryChange}
            />
            <label>Posted Date</label>
            <input
              type="text"
              className="form-control"
              placeholder="Enter Posted Date"
              value={postedDate}
              onChange={handlePostedDateChange}
            />
          </div>
          <button type="submit" className="btn btn-primary">
            Submit
          </button>
        </form>
      </fieldset>
    </div>
  );
}
