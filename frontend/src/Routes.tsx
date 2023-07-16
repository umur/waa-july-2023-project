import Login from "./pages/Login";
import { FC, Fragment, useEffect, useState } from "react";
import { Link, Navigate, Route, Routes, useNavigate } from "react-router-dom";
import Signup from "./pages/Signup";
import jwt_decode from "jwt-decode";
import { useUserContext } from "./context/UserContext";
import IAccessToken from "./types/IAccessToken";
import Dashboard from "./pages/Dashboard";
import Jobs from "./pages/Jobs";
import Charts from "./Charts/Charts";
import Profile from "./pages/Profile";
import useRole from "./hooks/useRole";
import Students from "./pages/Students";

const AppRoutes: FC = () => {
  const { user, updateUser } = useUserContext();
  const navigate = useNavigate();
  const { isFaculty } = useRole();

  useEffect(() => {
    if (localStorage.getItem("accessToken")) {
      const decoded: IAccessToken = jwt_decode(
        localStorage.getItem("accessToken") || ""
      );
      updateUser({
        version: 0,
        email: decoded.sub,
        firstName: decoded.firstName,
        lastName: decoded.lastName,
        city: decoded.city,
        state: decoded.state,
        major: decoded.major,
        roles: [
          {
            role: decoded.roles[0].authority,
          },
        ],
        enabled: true,
        jobApplications: [],
      });

      navigate("/");
    }
  }, []);

  const handleSignout = () => {
    localStorage.clear();
    updateUser(null);
  };

  return (
    <Fragment>
      <nav className="navbar d-flex align-center justify-between">
        <div>
          <h3>Alumni Management Portal</h3>
        </div>
        <div>
          {" "}
          {!user && (
            <ul className="d-flex align-center">
              <li>
                <Link className="d-flex align-center justify-center" to="login">
                  Login
                </Link>
              </li>
              <li className="d-flex align-center justify-center">
                <Link
                  className="d-flex align-center justify-center"
                  to="signup"
                >
                  Signup
                </Link>
              </li>
            </ul>
          )}
          {user && (
            <ul className="d-flex align-center">
              <li className="d-flex align-center justify-center">
                <Link
                  className="d-flex align-center justify-center"
                  to="dashboard"
                >
                  Dashboard
                </Link>
              </li>
              <li>
                <Link className="d-flex align-center justify-center" to="jobs">
                  Jobs
                </Link>
              </li>
              <li>
                <Link
                  className="d-flex align-center justify-center"
                  to="Profile"
                >
                  Profile
                </Link>
              </li>
              {isFaculty && (
                <li>
                  <Link
                    className="d-flex align-center justify-center"
                    to="students"
                  >
                    Students
                  </Link>
                </li>
              )}
              <li>
                <Link
                  className="d-flex align-center justify-center"
                  onClick={handleSignout}
                  to="login"
                >
                  Signout
                </Link>
              </li>
            </ul>
          )}
        </div>
      </nav>
      <Routes>
        <Route path="login" element={<Login />} />
        <Route path="signup" element={<Signup />} />
        {user != null ? (
          <>
            <Route path="dashboard" element={<Dashboard />} />
            <Route path="jobs" element={<Jobs />} />
            <Route path="profile" element={<Profile />} />
            <Route path="students" element={<Students />} />
          </>
        ) : (
          <Route path="*" element={<Navigate to="/login" replace={true} />} />
        )}
        <Route path="*" element={<Navigate to="/dashboard" replace={true} />} />
      </Routes>
      {/* <Charts /> */}
    </Fragment>
  );
};
export default AppRoutes;
