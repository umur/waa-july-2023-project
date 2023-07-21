import  { useState } from "react";

export default function AddJob({ handleAddJob }) {
  const [jobTitle, setJobTitle] = useState("");
  const [jobDescription, setJobDescription] = useState("");
  const [jobLocation, setJobLocation] = useState("");
  const [company, setCompany] = useState("");
  const [jobSalary, setJobSalary] = useState("");
  const [postedDate, setPostedDate] = useState("");

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
    setCompany(e.target.value);
  };

  const handleJobSalaryChange = (e) => {
    setJobSalary(e.target.value);
  };

  const handlePostedDateChange = (e) => {
    setPostedDate(e.target.value);
  };

  


  const handleSubmit = (e) => {
    e.preventDefault();

    // Create a new job object
    const newJob = {
      id: Date.now(), // Generate a unique ID (you can modify this as needed)
      jobTitle,
      jobDescription,
      jobLocation,
      company,
      jobSalary,
      postedDate,
    };

    // Pass the new job to the parent component

    handleAddJob(newJob);   


    // Reset the form fields
    setJobTitle("");
    setJobDescription("");
    setJobLocation("");
    setCompany("");
    setJobSalary("");
    setPostedDate("");
  };
  const style = {
    margin: 'auto',
    width: '60%',
    border: '3px solid green',
    padding: '20px',
   
    };

  return (
    <div style={style}>
      <h1>Add Job</h1>
      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label>Job Title</label>
          <input
            type="text"
            className="form-control"
            placeholder="Enter Job Title"
            value={jobTitle}
            onChange={handleJobTitleChange}
            required
          />
          <label>Job Description</label>
          <input
            type="text"
            className="form-control"
            placeholder="Enter Job Description"
            value={jobDescription}
            onChange={handleJobDescriptionChange}
            required
          />
          <label>Job Location</label>
          <input
            type="text"
            className="form-control"
            placeholder="Enter Job Location"
            value={jobLocation}
            onChange={handleJobLocationChange}
            required
          />
          <label>Company</label>
          <input
            type="text"
            className="form-control"
            placeholder="Enter Company"
            value={company}
            onChange={handleCompanyChange}
            required
          />
          <label>Job Salary</label>
          <input
            type="text"
            className="form-control"
            placeholder="Enter Job Salary"
            value={jobSalary}
            onChange={handleJobSalaryChange}
            required
          />
          <label>Posted Date</label>
          <input
            type="text"
            className="form-control"
            placeholder="Enter Posted Date"
            value={postedDate}
            onChange={handlePostedDateChange}
            required
          />
        </div>
        <br/>
        <button type="submit" className="btn btn-primary">
          Submit
        </button>
      </form>
    </div>
  );
}
