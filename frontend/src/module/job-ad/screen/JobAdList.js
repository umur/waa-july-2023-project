import React, { useEffect, useState } from "react";
import { jobAdService } from "../service/job-ad.service";
import { utility } from "../../../util/utility";
import { Link, useNavigate } from "react-router-dom";

function JobAdList() {
  let user = JSON.parse(localStorage.getItem("loggedInUser") || String("{}"));
  const [list, setList] = useState([]);
  let navigate = useNavigate();

  const getList = () => {
    jobAdService.getList().then((_list) => setList(_list));
  };

  useEffect(() => {
    getList();
    return () => {
      setList([]);
    };
  }, []);

  const handleDelete = (id) => {
    const result = window.confirm("Are you sure you want to delete?");

    if (result) {
      jobAdService.deleteJobAd(id).then((x) => {
        getList();
      });
    }
  };

  return (
    <div className="card card-md mx-auto">
      <div className="card-body">
        <div className="row mb-4">
          <div className="col-6">
            <h5 className="card-title">Job ads ({list.length})</h5>
          </div>
          <div className="col-6">
            <button
              className="btn btn-primary btn-sm float-end"
              onClick={() => navigate("/job-ads/add")}
            >
              Add Job Ad
            </button>
          </div>
        </div>
        <table className="table">
          <thead>
            <tr>
              <th scope="col">#</th>
              <th scope="col">Company name</th>
              <th scope="col">Description</th>
              <th scope="col">State</th>
              <th scope="col">City</th>
              <th scope="col">Benefits</th>
              <th scope="col">Created student</th>
              <th scope="col">Date created</th>
              <th scope="col">Actions</th>
            </tr>
          </thead>
          <tbody>
            {list.map((l, i) => (
              <tr key={l.id}>
                <th scope="row">{i + 1}</th>
                <td>
                  <span className="text-primary">
                    <Link to={`/job-ads/${l.id}/edit`}>{l.companyName}</Link>
                  </span>
                </td>
                <td>{l.description}</td>
                <td>{l.state}</td>
                <td>{l.city}</td>
                <td>{l.benefits}</td>
                <td>{utility.getFullName(l.createdStudent)}</td>
                <td>{new Date(l.dateCreated).toLocaleString()}</td>
                {l.createdStudent.id === user.id ? (
                  <td>
                    <Link to={`/job-ads/${l.id}/edit`}>Edit</Link>
                    <a
                      className="px-2"
                      href="#"
                      onClick={() => handleDelete(l.id)}
                    >
                      Delete
                    </a>
                  </td>
                ) : (
                  <td>
                    <Link to={`/job-ads/${l.id}/edit`}>Details</Link>
                  </td>
                )}
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}

export default JobAdList;
