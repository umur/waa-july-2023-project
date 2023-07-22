import React from "react";

import { useState, useEffect } from "react";

import axios from "axios";

import Swal from "sweetalert2"; // Import SweetAlert

export default function ListOfJobs() {
  const [jobAdvertisements, setJobAdvertisements] = useState([]);

  useEffect(() => {
    fetchListofJobs();
  }, []);

  const fetchListofJobs = async () => {
    try {
      const response = await axios.get("http://localhost:8080/jobAdverts");

      setJobAdvertisements(response.data);
    } catch (error) {
      console.error("Error fetching data:", error);
    }
  };

  const handleApply = (jobId) => {
    console.log(`Applying for job with ID: ${jobId}`);

    Swal.fire({
      icon: "success",

      title: "Job Applied Successfully!",

      text: "Congratulations, your job application was successful.",

      confirmButtonText: "OK",
    });
  };

  return (
    <div className="container mt-4">
      <h5 className="mb-4">List Of Jobs</h5>

      <table className="table table-striped table-bordered">
        <thead className="bg-info text-white">
          <tr>
            <th>Position</th>
            <th>Company</th>
            <th>Date</th>
            <th>Job Applied Date</th>
            <th>Street</th>
            <th>City</th>
            <th>State</th>
            <th>Zip</th>
            <th>Apply</th> {/* New column for the Apply button */}
          </tr>
        </thead>

        <tbody>
          {jobAdvertisements.map((job) => (
            <tr key={job.id}>
              <td>{job.position}</td>

              <td>{job.companyName}</td>

              <td>{job.date}</td>

              <td>{job.jobAppliedDate}</td>

              <td>{job.address?.street}</td>

              <td>{job.address?.city}</td>

              <td>{job.address?.state}</td>

              <td>{job.address?.zip}</td>

              <td>
                <button
                  className="btn btn-primary"
                  onClick={() => handleApply(job.id)}>
                  Apply
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}
