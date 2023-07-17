import "./App.css";
import ShowUsers from "./ShowUsers";
import { BrowserRouter, Link, Route, Routes } from "react-router-dom";
import UserDetails from "./UserDetails";
import Login from "./Login";
import { useEffect, useState } from "react";

const App = () => {
  const [user, setUser] = useState(null);

  useEffect(() => {
    const storageUser = localStorage.getItem("user");

    if (storageUser) {
      setUser(storageUser);
    }
  }, []);

  return user ? (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<ShowUsers />} />
        <Route path="/user-details/:id" element={<UserDetails />} />
        <Route path="/users" element={<ShowUsers />} />
      </Routes>
    </BrowserRouter>
  ) : (
    <Login setUser={setUser} />
  );
};

export default App;
