import { useEffect, useState } from "react";
import axios from "axios";
import miuLogo from "./miu_logo.jpg";

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
      console.log(result.data.jwtToken)
      localStorage.setItem("user", result.data.jwtToken);
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
      <img style={{ width: 400, height: 150 }} src={miuLogo} alt="MIU Logo" />

      <br></br>
      <div>Login Screen</div>

      <br></br>
      <div>Please write down your credentials</div>

      <div>
        <br></br>
        <div>Email</div>
        <br></br>
        <input
          placeholder="Email"
          name="email"
          value={values.email}
          onChange={handleChange}
        />
        <br></br>

        <br></br>
        <div>Password</div>
        <br></br>
        <input
          placeholder="Password"
          name="password"
          type="password"
          value={values.password}
          onChange={handleChange}
        />
        <br></br>
        <br></br>
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
