import { React, useState, useEffect } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { cvService } from "../service/cv.service";
import { utility } from "../../../util/utility";

function EditCV() {
  const { id, jobAdId, studentId } = useParams();
  const [cv, setCv] = useState();
  let navigate = useNavigate();
  const isEditing = window.location.pathname.endsWith("/edit");
  const isDetail = window.location.pathname.endsWith("/detail");

  const [formData, setFormData] = useState({
    text: "",
  });

  useEffect(() => {
    if (isEditing || isDetail) {
      if (isDetail) {
        cvService.getForCreator(id, studentId).then((x) => {
          setCv(x);
          setFormData(x);
        });
      } else {
        cvService.get(id).then((x) => {
          setCv(x);
          setFormData(x);
        });
      }
    }

    return () => {
      setCv(undefined);
    };
  }, [id, jobAdId, studentId]);

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
      await cvService.update(formData);
    } else {
      formData.id = { jobAdId };
      await cvService.add(formData, jobAdId);
    }

    navigate("/cvs");
    alert(`CV ${isEditing ? "updated" : "created"} successfully.`);
  };

  return (
    <div className="card card-md mx-auto container">
      <div className="card-body">
        <h5 className="card-title mb-4">
          {isEditing || isDetail
            ? `CV for ${cv?.jobAd.companyName ?? "N/A"}`
            : "Add CV"}
        </h5>
        <form onSubmit={handleSubmit} className="pb-3">
          {isDetail && cv?.student && (
            <>
              <label>Student</label>
              <input
                className="form-control"
                readOnly
                value={utility.getFullName(cv.student)}
              ></input>
            </>
          )}
          {isEditing || isDetail ? (
            <>
              <label>Created date</label>
              <input
                className="form-control"
                readOnly
                value={cv?.createdDate}
              ></input>
            </>
          ) : (
            <label>Please write your CV below.</label>
          )}
          {(isEditing || isDetail) && <label>CV</label>}
          <textarea
            name="text"
            rows={10}
            readOnly={isDetail}
            className="form-control"
            value={formData.text}
            onChange={handleChange}
          />

          {!isDetail && (
            <button className="btn btn-primary mt-4" type="submit">
              Save
            </button>
          )}
        </form>
      </div>
    </div>
  );
}

export default EditCV;
