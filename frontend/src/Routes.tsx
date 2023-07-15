import Login from "./pages/Login";
import { FC, Fragment, useState } from "react";
import { Link, Navigate, Route, Routes } from "react-router-dom";
import Signup from "./pages/Signup";
import { useUserContext } from "./context/UserContext";

const AppRoutes: FC = () => {
  const { user } = useUserContext();
  const [isLoggedIn, setIsLoggedIn] = useState<boolean>(!!user);

  return (
    <Fragment>
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
        {user != null ? (
          <>
            <Route path="dashbord" element={<div>tt</div>} />
            <Route path="signup" element={<Signup />} />
          </>
        ) : (
          <Route path="*" element={<Navigate to="/login" replace={true} />} />
        )}
        <Route path="*" element={<Navigate to="/dashbord" replace={true} />} />
      </Routes>
    </Fragment>
  );
};
export default AppRoutes;
