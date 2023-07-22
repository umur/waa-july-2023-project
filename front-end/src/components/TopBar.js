import { useContext, useEffect, useState } from "react";
import ProfileButton from "./ProfileButton";
import { IdContext } from "../App";
import axios from "axios";
// import { Link } from "react-router-dom";

function TopBar() {
  const userId = useContext(IdContext);

  const initialUser = {
    id: "loading",
    firstName: "loading",
    lastName: "loading",
    email: "loading",
    role: "loading",
  };

  const [user, setUser] = useState(initialUser);

  const fetchData = async () => {
    try {
      const { data } = await axios.get(
        "http://localhost:8080/faculties/" + userId
      );
      setUser(data);
    } catch (error) {
      console.error("Error fetching faculty data:", error);
    }
  };

  useEffect(() => {
    fetchData();
  }, []);

  console.log(user);

  return (
    // <!-- Topbar -->
    <div className="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
      {/* <!-- Sidebar Toggle (Topbar) --> */}
      <button
        id="sidebarToggleTop"
        className="btn btn-link d-md-none rounded-circle mr-3">
        <i className="fa fa-bars"></i>
      </button>

      {/* <!-- Topbar Navbar --> */}
      <ul className="navbar-nav ml-auto">
        <div className="topbar-divider d-none d-sm-block "></div>

        {/* <!-- Nav Item - User Information --> */}
        <li className="nav-item dropdown no-arrow my-auto">
          <ProfileButton firstName={user.firstName} lastName={user.lastName} />
        </li>
      </ul>
    </div>
    // {/* <!-- End of Topbar --> */}
  );
}

export default TopBar;
