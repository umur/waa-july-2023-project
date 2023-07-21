import { useContext, useEffect, useState } from "react";
import { IdContext } from "../App";
import axios from "axios";

export const FacultyEdit = () => {
  const userId = useContext(IdContext);
  console.log("inside Faculty edit ID = " + userId);

  const initialFaculty = {
    id: "loading",
    firstName: "loading",
    lastName: "loading",
    email: "loading",
    role: "loading",
    phone_number: "loading",
    department: "loading",
    title: "loading",
    comments: "loading",
    address: "loading",
    enabled: "loading",
    _admin: "loading",
    credentialsNonExpired: "loading",
    accountNonExpired: "loading",
    accountNonLocked: "loading",
  };

    const [faculty, setFaculty] = useState(initialFaculty);

  //   useEffect(() => {
  //     (async () => {
  //       const { data } = await axios.get(
  //         "http://localhost:8080/faculties/email/nguillond1@auda.org.au"
  //       );
  //       setFaculty(data);
  //     })();
  //   }, [faculty]);

  const fetchData = async () => {
    try {
      const { data } = await axios.get(
        "http://localhost:8080/faculties/"+userId
      );
      setFaculty(data);
    } catch (error) {
      console.error("Error fetching faculty data:", error);
    }
  };

  useEffect(() => {
    fetchData();
  }, []);

  return (
    <div className="container rounded bg-white mt-5 mb-5">
      <div className="row">
        <div className="col-md-3 border-right">
          <div className="d-flex flex-column align-items-center text-center p-3 py-5">
            <img
              className="rounded-circle mt-5"
              width="150px"
              src="https://st3.depositphotos.com/15648834/17930/v/600/depositphotos_179308454-stock-illustration-unknown-person-silhouette-glasses-profile.jpg"
            />
            <span className="font-weight-bold">{faculty.firstName} {faculty.lastName}</span>
            <span className="text-black-50">{faculty.email}</span>
            <span> </span>
          </div>
        </div>
        <div className="col-md-5 border-right">
          <div className="p-3 py-5">
            <div className="d-flex justify-content-between align-items-center mb-3">
              <h4 className="text-right">Profile Settings</h4>
            </div>
            <div className="row mt-2">
              <div className="col-md-6">
                <label className="labels">Name</label>
                <input
                  type="text"
                  className="form-control"
                  placeholder={faculty.firstName}
                  defaultValue=""
                />
              </div>
              <div className="col-md-6">
                <label className="labels">Surname</label>
                <input
                  type="text"
                  className="form-control"
                  defaultValue=""
                  placeholder={faculty.lastName}
                />
              </div>
            </div>
            <div className="col-md-12">
                <label className="labels">Email ID</label>
                <input
                  type="text"
                  className="form-control"
                  placeholder={faculty.email}
                  defaultValue=""
                />
              </div>
            <div className="row mt-3">
              <div className="col-md-12">
                <label className="labels">Mobile Number</label>
                <input
                  type="text"
                  className="form-control"
                  placeholder={faculty.phone_number}
                  defaultValue=""
                />
              </div>
              <div className="col-md-12">
                <label className="labels">Street</label>
                <input
                  type="text"
                  className="form-control"
                  placeholder="Street"
                  defaultValue=""
                />
              </div>
              <div className="col-md-12">
                <label className="labels">Zip</label>
                <input
                  type="text"
                  className="form-control"
                  placeholder="Zip"
                  defaultValue=""
                />
              </div>
              {/* <div className="col-md-12">
                <label className="labels">Postcode</label>
                <input
                  type="text"
                  className="form-control"
                  placeholder="enter address line 2"
                  defaultValue=""
                />
              </div> */}
              {/* <div className="col-md-12">
                <label className="labels">State</label>
                <input
                  type="text"
                  className="form-control"
                  placeholder="enter address line 2"
                  defaultValue=""
                />
              </div> */}
              {/* <div className="col-md-12">
                <label className="labels">Area</label>
                <input
                  type="text"
                  className="form-control"
                  placeholder="enter address line 2"
                  defaultValue=""
                />
              </div> */}
              
              {/* <div className="col-md-12">
                <label className="labels">Title</label>
                <input
                  type="text"
                  className="form-control"
                  placeholder={faculty.title}
                  defaultValue=""
                />
              </div> */}
            </div>
            <div className="row mt-3">
              <div className="col-md-6">
                <label className="labels">City</label>
                <input
                  type="text"
                  className="form-control"
                  placeholder="city"
                  defaultValue=""
                />
              </div>
              <div className="col-md-6">
                <label className="labels">State/Region</label>
                <input
                  type="text"
                  className="form-control"
                  defaultValue=""
                  placeholder="state"
                />
              </div>
            </div>
            <div className="mt-5 text-center">
              <button className="btn btn-primary profile-button" type="button">
                Save Profile
              </button>
            </div>
          </div>
        </div>
        <div className="col-md-4">
          <div className="p-3 py-5">
            <div className="d-flex justify-content-between align-items-center experience">
              <span>Edit Department</span>
              <span className="border px-3 p-1 add-experience">
                <i className="fa fa-plus"></i>&nbsp;Department
              </span>
            </div>
            <br />
            <div className="col-md-12">
              <label className="labels">Department</label>
              <input
                type="text"
                className="form-control"
                placeholder={faculty.department}
                defaultValue=""
              />
            </div>{" "}
            <br />
            <div className="col-md-12">
              <label className="labels">Title</label>
              <input
                type="text"
                className="form-control"
                placeholder={faculty.title}
                defaultValue=""
              />
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};
