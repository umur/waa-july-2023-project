import React, { Component } from 'react';
import axios from 'axios';

class JobList extends Component {
    constructor(props) {
        super(props);
        this.state = {
            jobs: []
        }
        
    }
    componentDidMount() {
        axios.get('http://localhost:8080/all/jobs')
            .then(response => {
                this.setState({ jobs: response.data })
            })
            .catch(error => {
                console.log(error);
            })
    }
    
    handleUpdate = (jobId) => {
        // Retrieve the job data that needs to be updated based on the job ID
        const jobToUpdate = this.state.jobs.find(job => job.jobId === jobId);
      
        // Update the form inputs with the retrieved job data
        setJobTitle(jobToUpdate.jobTitle);
        setJobDescription(jobToUpdate.jobDescription);
        setJobLocation(jobToUpdate.jobLocation);
        setCompany(jobToUpdate.company);
        setJobSalary(jobToUpdate.jobSalary);
        setPostedDate(jobToUpdate.postedDate);
      };

    render() {
        return (
            <div>
                <h1>Welcome To Student Page</h1>
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
                        <th>Posted Date</th>
                        <th>Job Salary</th>                       
                        <th>Actions</th>
                        </tr>
                    
                        </thead>
                        <tbody>
                            {
                                 this.state.jobs.map(
                                    job =>
                                        <tr key={job.jobId}>
                                            <td>{job.jobId}</td>
                                            <td>{job.jobTitle}</td>
                                            <td>{job.jobDescription}</td>
                                            <td>{job.jobLocation}</td>
                                            <td>{job.company}</td>
                                            <td>{job.postedDate}</td>
                                            <td>{job.jobSalary}</td>
                                            <td>
                                                <button  className="btn btn-primary" onClick={() => this.handleUpdate(job.jobId)}>Update</button>
                                                <button className="btn btn-danger">Delete</button>
                                            </td>
                                        </tr>
                                )

                            }
                              
                            
                        </tbody>
                    </table>
                    

            </div>  
        </div>
            </div>
        );
    }
}

export default JobList;