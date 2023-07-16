import { useEffect, useState } from "react";
import axios from "axios";

function Login({ setUser }) {
  const [values, setValues] = useState({
    email: "",
    password: "",
  });

  const handleChange = ({ target }) => {
    setValues({ ...values, [target.name]: target.value });
  };

  const loginRequest = {
    email: values.email,
    password: values.password,
  };

  const login = async () => {
    const result = await axios.post("/auth/authenticate", loginRequest);

    if (result.status === 200) {
      setUser(result.data);
      localStorage.setItem("user", JSON.stringify(result.data.jwtToken));
      console.log(result.status);
      console.log(result.data.jwtToken);
    } else {
      console.log(result.status);
    }
  };

  const onLoginClick = () => {
    login();
  };

  const onSignUpClick = () => {};

  return (
    <div className="Login">
      <br></br>
      <div>Login Screen</div>

      <br></br>
      <div>Please write down your credentials</div>

      <div>
        <br></br>
        <div>Email</div>
        <input
          placeholder="Email"
          name="email"
          value={values.email}
          onChange={handleChange}
        />
        <br></br>

        <br></br>
        <div>Password</div>
        <input
          placeholder="Password"
          name="password"
          value={values.password}
          onChange={handleChange}
        />
        <br></br>

        <button onClick={onLoginClick}>Login in</button>
        <br></br>
        <br></br>
        <br></br>
        <button onClick={onSignUpClick}>Sign up</button>
      </div>
    </div>
  );
}
export default Login;
