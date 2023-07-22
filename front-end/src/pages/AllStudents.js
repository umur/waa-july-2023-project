import React from "react";

import { useState, useEffect } from "react";

import axios from "axios";
import Swal from "sweetalert2"; // Import SweetAlert

export default function AllStudents() {
  const [students, setStudents] = useState([]);

  useEffect(() => {
    fetStudents();
  }, []);

  const fetStudents = async () => {
    try {
      const response = await axios.get("http://localhost:8080/students");

      setStudents(response.data);
    } catch (error) {
      console.error("Error fetching data:", error);
    }
  };

  const handleApply = (jobId) => {
    console.log(`Applying for job with ID: ${jobId}`);

    Swal.fire({
    
      icon: "comment",
    
      title: "Write Comment",
    
      text: "Comment will be saved for the student",
    
      input: "text", 
    
      inputPlaceholder: "Enter your comment",
    
      confirmButtonText: "Submit",
    
    }).then((result) => {
    
      if (result.isConfirmed && result.value) {
    
        const inputValue = result.value;    
        console.log("User input:", inputValue);
    
      }
    
    });
    
  };

  return (
    <div className="container mt-4">
      <h5 className="mb-4">List Of Students</h5>

      {console.log(students)}

      <table className="table table-striped table-bordered">
        <thead className="bg-info text-white">
          <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Phone Number Applied Date</th>
            <th>Major</th>
            <th>Comment</th>
          </tr>
        </thead>

        <tbody>
          {students.map((student) => (
            <tr key={student.id}>
              <td>{student.firstName}</td>
              <td>{student.lastName}</td>
              <td>{student.email}</td>
              <td>{student.phoneNumber}</td>
              <td>{student.major}</td>
              <td>
                <button className="btn btn-primary" onClick={() => handleApply(student.id)}>Comment</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}
