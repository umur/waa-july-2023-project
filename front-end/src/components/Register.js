import { useState } from "react";
import axios from "axios";
import { Navigate } from "react-router-dom";

export const Register = () => {
  const [role, setRole] = useState("");
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [navigate, setNavigate] = useState(false);

  const handleOptionChange = (event) => {
    setRole(event.target.value);
  };

  const submit = async (e) => {
    e.preventDefault();

    await axios.post("http://localhost:8080/auth/register/"+role, {
      name,
      email,
      password,
      role,
    });
    setNavigate(true);
  };

  if (navigate) {
    return <Navigate to="/login" />;
  }

  return (
    <main className="form-signin w-100 m-auto">
      <form onSubmit={submit}>
        <h1 className="h3 mb-3 fw-normal">Please sign up</h1>

        <div className="form-floating">
          <input
            type="text"
            className="form-control"
            id="name"
            placeholder="Your Name"
            onChange={(e) => setName(e.target.value)}
          />
          <label htmlFor="name">Name</label>
        </div>

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

        <div>
          <label>
            <input
              type="radio"
              value="STUDENT"
              checked={role === "STUDENT"}
              onChange={handleOptionChange}
            />
            Student
          </label>

          <div>
            <label>
              <input
                type="radio"
                value="FACULTY"
                checked={role === "FACULTY"}
                onChange={handleOptionChange}
              />
              Faculty
            </label>
          </div>
        </div>

        <button className="btn btn-primary w-100 py-2" type="submit">
          Register
        </button>
      </form>
    </main>
  );
};
