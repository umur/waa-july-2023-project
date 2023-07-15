import { Link, Navigate, Route, Routes } from "react-router-dom";
import Login from "./pages/Login";
import Signup from "./pages/Signup";
import { UserContext } from "./context/UserContext";
import { useState } from "react";
import { IUser } from "./types/IUser";

function App() {
  const isLogged = useState(false);

  return (
    <>
      <nav className="navbar">
        <ul className="d-flex align-center">
          <li>
            <Link className="d-flex align-center justify-center" to="login">
              Login
            </Link>
          </li>
          <li className="d-flex align-center justify-center">
            <Link className="d-flex align-center justify-center" to="signup">
              Signup
            </Link>
          </li>
        </ul>
      </nav>
      <Routes>
        <Route path="login" element={<Login />} />
        <Route path="signup" element={<Signup />} />
        <Route path="*" element={<Navigate to="/login" replace={true} />} />
      </Routes>
    </>
  );
}

export default App;
