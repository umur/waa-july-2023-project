import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { cvService } from "../service/cv.service";

function CVList() {
  const [list, setList] = useState([]);

  const getList = () => {
    cvService.getList().then((_list) => setList(_list));
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
      cvService.deleteCv(id).then((x) => {
        getList();
      });
    }
  };

  return (
    <div className="card card-md mx-auto">
      <div className="card-body">
        <div className="row mb-4">
          <div className="col-6">
            <h5 className="card-title">CVs ({list.length})</h5>
          </div>
        </div>
        <table className="table">
          <thead>
            <tr>
              <th scope="col">#</th>
              <th scope="col">Company</th>
              <th scope="col">Created Date</th>
              <th scope="col">Text</th>
              <th scope="col">Actions</th>
            </tr>
          </thead>
          <tbody>
            {list.map((l, i) => (
              <tr key={l.id}>
                <th scope="row">{i + 1}</th>
                <td>
                  <span className="text-primary">{l.jobAd.companyName}</span>
                </td>
                <td>{l.createdDate}</td>
                <td>{`${l.text.substring(0, 10)}...`}</td>{" "}
                <td>
                  <Link to={`/cvs/${l.id.jobAdId}/edit`}>Edit</Link>
                  <a
                    className="px-2"
                    href="#"
                    onClick={() => handleDelete(l.id)}
                  >
                    Delete
                  </a>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}

export default CVList;
