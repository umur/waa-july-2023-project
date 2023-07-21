import React, { useEffect, useState } from "react";
import axios from "axios";
import ReactDOM from "react-dom";
import AddJob from "../studentmethods/AddJob";
import Edit from "../studentmethods/Edit";
import SearchJob from "../studentmethods/SearchJob";
import AddWorkExperience from "../studentmethods/AddWorkExperience";
import { useNavigate } from "react-router-dom";

export default function Student() {
  const [jobs, setJobs] = useState([]);
  const [showTable, setShowTable] = useState(true);
  const [editedJob, setEditedJob] = useState(null);
  const navigate = useNavigate();

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
  const handleAddJob = (newJob) => {
    // Update the job list
    const updatedJobs = [...jobs];
    updatedJobs.push(newJob);
    setJobs(updatedJobs);
    // Send the new job data to the server for persistence
    axios.post("http://localhost:8080/jobs", newJob).then((response) => {
        console.log(response.data);
        })
        .catch((error) => {
        console.error(error);
        });

    // Redirect back to the job list table
    setShowTable(true);
  };

//   const addJopBtn = () => {
//     console.log("Add Job Button Clicked");
//     setShowTable(false);
//   };
  const addJobBtn = () => {
    console.log("Add Job Button Clicked");
    ReactDOM.render(
      <AddJob setJobs={setJobs} />,
      document.getElementById("root")
    );
    setShowTable(false);
  };

  const editBtn = (jobId) => {
    console.log("Edit Button Clicked");
    const jobToEdit = jobs.find((job) => job.id === jobId);
    setEditedJob(jobToEdit);
    setShowTable(false);
  };

  const handleUpdate = (updatedJob) => {
    const updatedJobs = jobs.map((job) =>
      job.id === updatedJob.id ? updatedJob : job
    );
    setJobs(updatedJobs);
    setShowTable(true);
    // Send the updated job data to the server for persistence
    axios
      .put(`http://localhost:8080/jobs/${updatedJob.id}`, updatedJob)
      .then((response) => {
        console.log(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  };

  const redirectToTable = () => {
    setShowTable(true);
  };

    const handleSearch = (filteredJobs) => {
    console.log(filteredJobs);
    setJobs(filteredJobs);
    setShowTable(true);
    };


    const searchBtn = () => {
        ReactDOM.render(
          <SearchJob handleSearch={handleSearch} data={jobs} />,
          document.getElementById("root")
        );
      };

  const deleteBtn = (jobId) => {
    console.log("Delete Button Clicked");
    const updatedJobs = jobs.filter((job) => job.id !== jobId);
    setJobs(updatedJobs);
    // Send the delete request to the server for persistence
    axios
      .delete(`http://localhost:8080/student/${jobId}`)
      .then((response) => {
        console.log(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  };

  const addWorkexp = () => {

    navigate("/addwork");
    // ReactDOM.render(<AddWorkExperience />, document.getElementById("root"));
  };

  const style = {
    margin: 10,
  };

  return (
    <div>
      <nav className="navbar navbar-expand-lg bg-body-tertiary">
        <div className="container">
        <button
            type="button"
            className="btn btn-primary"
            onClick={addJobBtn}
          >
            Add Job
          </button>
          <button type="button" className="btn btn-primary" onClick={searchBtn}>
            Search Job
          </button>
          
          <button
            type="button"
            className="btn btn-primary"
            onClick={addWorkexp}
          >
            Add Work experience
          </button>
        </div>
      </nav>

      <h1>Welcome To Student Page</h1>
      <br />
      {showTable ? (
        <div className="container">
          <div className="row">
            <table className="table table-striped table-bordered">
              <thead>
                <tr>
                  <th>Job ID</th>
                  <th>Job Title</th>
                  <th>Job Description</th>
                  <th>Job Location</th>
                  <th>Company</th>
                  <th>Posted Date</th>
                  <th>Job Salary</th>
                  <th>Actions</th>
                </tr>
              </thead>
              <tbody>
                {jobs.map((job) => (
                  <tr key={job.id}>
                    <td>{job.id}</td>
                    <td>{job.jobTitle}</td>
                    <td>{job.jobDescription}</td>
                    <td>{job.jobLocation}</td>
                    <td>{job.copanyName}</td>
                    <td>{job.postedDate}</td>
                    <td>{job.jobSalary}</td>

                    <td>
                      <button
                       style={style}
                        onClick={() => editBtn(job.id)}
                        className="btn btn-info"
                      >
                        Update
                      </button>
                      <button
                        
                        onClick={() => deleteBtn(job.id)}
                        className="btn btn-danger"
                      >
                        Delete
                      </button>
                    </td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        </div>
      ) : (
        <Edit
          job={editedJob}
          handleUpdate={handleUpdate}
          redirectToTable={redirectToTable}
        />
      )}
   
       
        

      

    </div>
  );
}
