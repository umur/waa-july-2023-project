import React, { Component } from 'react';
import axios from 'axios';

class StudentList extends Component {
    constructor(props) {
        super(props);
        this.state = {
            student: []
        }
        
    }
    componentDidMount() {
        axios.get('http://localhost:8080/student/students/all')
            .then(response => {
                this.setState({ student: response.data })
            })
            .catch(error => {
                console.log(error);
            })
    }
    
    handleUpdate = (jobId) => {
        // Retrieve the job data that needs to be updated based on the job ID
        const jobToUpdate = this.state.student.find(job => job.jobId === jobId);
      
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
                <h1>Welcome To Faculty Page</h1>
        <br/>
        <div className="container">
            <div className="row">
                <table className="table table-striped table-bordered">
                    <thead>
                        <tr>
                        <th>Student ID</th>
                        <th>Student First Name</th>
                        <th>Student Last Name</th>
                        <th>Student Email</th>
                        <th>Student Phone</th>
                        <th>Student Address</th>
                        </tr>

                        </thead>
                        <tbody>
                            {
                                    this.state.student.map(
                                        stu =>
                                            <tr key={stu.id}>
                                                <td>{stu.id}</td>
                                                <td>{stu.firstName}</td>
                                                <td>{stu.lastName}</td>
                                                <td>{stu.email}</td>
                                                <td>{stu.phone}</td>
                                                <td>{stu.address}</td>
                                                <td>
                                                    <button className="btn btn-info">Write Comment</button>
                                                    
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

export default StudentList;