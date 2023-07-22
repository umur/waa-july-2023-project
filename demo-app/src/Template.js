import axios from "axios";
import { Link } from "react-router-dom";

const Template = ({ setUser, children }) => (
  <div>
    <nav>
      <Link to="/users"> All Users </Link>
      <Link to="/Advertisements"> Advertisements </Link>
      <div
        style={{
          display: "flex",
          flex: 1,
          justifyContent: "flex-end",
        }}
      >
        <button
          onClick={() => {
            localStorage.removeItem("user");
            axios.defaults.headers.common["Authorization"] = undefined;
            setUser(null);
          }}
        >
          logout
        </button>
      </div>
    </nav>
    <main>{children}</main>
  </div>
);

export default Template;
