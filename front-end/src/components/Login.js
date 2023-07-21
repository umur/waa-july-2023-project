import { useContext, useState } from "react";
import axios from "axios";
import { Navigate } from "react-router-dom";
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
    return <Navigate to="/facultyedit" />;
  }

  if (navigate === "STUDENT") {
    return <Navigate to="/home" />;
  }

  return (
    <main className="form-signin w-100 m-auto">
      <form onSubmit={submit}>
        <h1 className="h3 mb-3 fw-normal">Please sign in</h1>

        <div className="form-floating">
          <input
            type="email"
            className="form-control"
            id="floatingInput"
            placeholder="name@example.com"
            onChange={(e) => setEmail(e.target.value)}
          />
          <label htmlFor="floatingInput">Email address</label>
        </div>
        <div className="form-floating">
          <input
            type="password"
            className="form-control"
            id="floatingPassword"
            placeholder="Password"
            onChange={(e) => setPassword(e.target.value)}
          />
          <label htmlFor="floatingPassword">Password</label>
        </div>
        <button className="btn btn-primary w-100 py-2" type="submit">
          Sign in
        </button>
      </form>
    </main>
  );
};
