import { React, useState, useEffect } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { jobAdService } from "../service/job-ad.service";
import { utility } from "../../../util/utility";
import { Link } from "react-router-dom";

function EditJobAd() {
  let user = JSON.parse(localStorage.getItem("loggedInUser") || String("{}"));
  const { id } = useParams();
  const [jobAd, setJobAd] = useState();
  let navigate = useNavigate();
  const isEditing = window.location.pathname.endsWith("/edit");

  const emptyJobAd = {
    companyName: "",
    description: "",
    state: "",
    city: "",
    benefits: "",
  };

  const [formData, setFormData] = useState(emptyJobAd);

  useEffect(() => {
    if (isEditing) {
      jobAdService.get(id).then((x) => {
        setJobAd(x);
        setFormData(x);
      });
    }

    return () => {
      setJobAd(undefined);
      setFormData(emptyJobAd);
    };
  }, [id]);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prevFormData) => ({
      ...prevFormData,
      [name]: value,
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (isEditing) {
      await jobAdService.update(formData);
    } else {
      await jobAdService.add(formData);
    }

    navigate("/job-ads");
    alert(`Job-Ad ${isEditing ? "updated" : "created"} successfully.`);
  };

  return (
    <div className="card card-md mx-auto container">
      <div className="card-body">
        <h5 className="card-title mb-4">
          {isEditing ? `Job-Ad #${jobAd?.id ?? "N/A"}` : "Add Job-Ad"}
        </h5>
        <form onSubmit={handleSubmit}>
          <div>
            <label>Company name</label>
            <input
              name="companyName"
              className="form-control"
              type="text"
              value={formData.companyName}
              onChange={handleChange}
            ></input>
          </div>
          <div className="row">
            <div className="col">
              <label>State</label>
              <input
                name="state"
                className="form-control"
                type="text"
                value={formData.state}
                onChange={handleChange}
              ></input>
            </div>
            <div className="col">
              <label>City</label>
              <input
                name="city"
                className="form-control"
                type="text"
                value={formData.city}
                onChange={handleChange}
              ></input>
            </div>
          </div>
          <div>
            <label>Description</label>
            <textarea
              name="description"
              className="form-control"
              value={formData.description}
              onChange={handleChange}
            />
          </div>
          <div>
            <label>Benefits</label>
            <textarea
              name="benefits"
              className="form-control"
              value={formData.benefits}
              onChange={handleChange}
            />
          </div>
          {isEditing && (
            <div className="mt-4">
              {jobAd?.createdStudent.id === user.id ? (
                <>
                  <h5>CV</h5>
                  {jobAd?.cvs && jobAd.cvs.length > 0 ? (
                    <table className="table">
                      <thead>
                        <tr>
                          <th scope="col">#</th>
                          <th scope="col">Text</th>
                          <th scope="col">Created Student</th>
                          <th scope="col">Created date</th>
                          <th scope="col">Action</th>
                        </tr>
                      </thead>
                      <tbody>
                        {jobAd.cvs.map((cv, i) => (
                          <tr key={cv.id.jobAdId}>
                            <td>{i + 1}</td>
                            <td>{`${cv.text.substring(0, 10)}...`}</td>{" "}
                            <td>{utility.getFullName(cv.student)}</td>
                            <td>{cv.createdDate}</td>
                            <td>
                              <Link
                                to={`/cvs/${cv.id.studentId}/${cv.id.jobAdId}/detail`}
                              >
                                Detail
                              </Link>
                            </td>
                          </tr>
                        ))}
                      </tbody>
                    </table>
                  ) : (
                    <span className="text-primary">
                      There are no CVs for this job ad.
                    </span>
                  )}
                </>
              ) : (
                <button
                  className="btn btn-primary"
                  onClick={() => navigate(`/job-ads/${jobAd?.id}/add-cv`)}
                >
                  Apply for this job
                </button>
              )}
            </div>
          )}

          {(!isEditing || jobAd?.createdStudent.id === user.id) && (
            <button className="btn btn-primary mt-4" type="submit">
              Save
            </button>
          )}
        </form>
      </div>
    </div>
  );
}

export default EditJobAd;
