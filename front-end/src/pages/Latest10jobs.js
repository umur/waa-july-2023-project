import React from "react";

import { useState, useEffect } from "react";

import axios from "axios";

export default function Latest10jobs() {
  const [jobAdvertisements, setJobAdvertisements] = useState([]);

  useEffect(() => {
    fetchJobsAdvertise();
  }, []);

  const fetchJobsAdvertise = async () => {
    try {
      const response = await axios.get(`http://localhost:8080/getTop10`);

      setJobAdvertisements(response.data);
    } catch (error) {
      console.error("Error fetching data:", error);
    }
  };

  return (
    <div className="container mt-4">
      <h5 className="mb-4">Top 10 Job Advertisements</h5>

      <table className="table table-striped table-bordered">
        <thead className="bg-info text-white">
          <tr>
            <th>Position</th>

            <th>Company</th>

            <th>Date</th>

            <th>Street</th>

            <th>jobAppliedDate</th>

            <th>City</th>

            <th>State</th>

            <th>Zip</th>
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
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}
