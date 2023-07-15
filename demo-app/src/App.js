import logo from "./logo.svg";
import "./App.css";
import ShowUsers from "./ShowUsers";
import { Link, Route, Routes } from "react-router-dom";
import UserDetails from "./UserDetails";

function App() {


  return (
    <div>
      <ul>
        <li>
          <Link to="/UserDetails/1">Back To Default User</Link>
        </li>
        <li>
          <Link to="/Users"> All Users </Link>
        </li>

      </ul>

      <Routes>
        <Route path="/UserDetails/:id" element={<UserDetails />} />
        <Route path="/Users" element={< ShowUsers />} />
      </Routes>

    </div>
  );
}
export default App;
