import { useContext, useState } from "react";
import axios from "axios";
import { Link, Navigate } from "react-router-dom";
import jwt_decode from "jwt-decode";
import { IdContext } from "../App";

export const Login = (props) => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [navigate, setNavigate] = useState(null);

  const userId = useContext(IdContext);

  const submit = async (e) => {
    e.preventDefault();

    const { data } = await axios.post(
      "http://localhost:8080/auth/authenticate",
      {
        email,
        password,
      }
      // { withCredentials: true }
    );

    axios.defaults.headers.common["Authorization"] = `Bearer ${data["token"]}`;

    console.log("Token is here " + data.token);
    var decoded = jwt_decode(data.token);

    console.log("Decoded token: " + decoded.role);
    console.log("Decoded token: " + decoded.id);
    props.setId(decoded.id);

    setNavigate(decoded.role);
  };

  if (navigate === "FACULTY") {
    return <Navigate to="/" />;
  }

  if (navigate === "STUDENT") {
    return <Navigate to="/" />;
  }

  return (
    <div className="bg-gradient-primary">
      <div className="container">
        {/* <!-- Outer Row --> */}
        <div className="row justify-content-center">
          <div className="col-xl-10 col-lg-12 col-md-9">
            <div className="card o-hidden border-0 shadow-lg my-5">
              <div className="card-body p-0">
                {/* <!-- Nested Row within Card Body --> */}
                <div className="row">
                  <div className="col-lg-6 d-none d-lg-block bg-login-image"></div>
                  <div className="col-lg-6">
                    <div className="p-5">
                      <div className="text-center">
                        <h1 className="h4 text-gray-900 mb-4">Welcome Back!</h1>
                      </div>
                      <form onSubmit={submit} className="user">
                        <div className="form-group">
                          <input
                            type="email"
                            className="form-control form-control-user"
                            id="exampleInputEmail"
                            aria-describedby="emailHelp"
                            placeholder="Enter Email Address..."
                            onChange={(e) => setEmail(e.target.value)}
                          />
                        </div>
                        <div className="form-group">
                          <input
                            type="password"
                            className="form-control form-control-user"
                            id="exampleInputPassword"
                            placeholder="Password"
                            onChange={(e) => setPassword(e.target.value)}
                          />
                        </div>
                        <div className="form-group">
                          <div className="custom-control custom-checkbox small">
                            <input
                              type="checkbox"
                              className="custom-control-input"
                              id="customCheck"
                            />
                            <label
                              className="custom-control-label"
                              htmlFor="customCheck">
                              Remember Me
                            </label>
                          </div>
                        </div>
                        <button type="submit"
                          className="btn btn-primary btn-user btn-block">
                          Login
                        </button>
                        <hr />
                      </form>
                      <hr />
                      <div className="text-center">
                        <Link className="small" href="#">
                          Forgot Password?
                        </Link>
                      </div>
                      <div className="text-center">
                        <Link to={"/register"} className="small">
                          Create an Account!
                        </Link>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};
