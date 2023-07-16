import { Link } from "react-router-dom";

const Template = ({ setUser, children }) => (
  <div>
    <ul>
      <li>
        <Link to="/user-details/1">Back To Default User</Link>
      </li>
      <li>
        <Link to="/users"> All Users </Link>
      </li>
      <li>
        <button
          onClick={() => {
            localStorage.removeItem("user");
            setUser(null);
          }}
        >
          logout
        </button>
      </li>
    </ul>
    {children}
  </div>
);

export default Template;
