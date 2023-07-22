import "./App.css";
import ShowUsers from "./ShowUsers";
import { BrowserRouter, Link, Route, Routes } from "react-router-dom";
import UserDetails from "./UserDetails";
import ShowAdvertisement from "./ShowAdvertisement";
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
        <Route path="/" element={<ShowUsers setUser={setUser} />} />
        <Route path="/user/:id" element={<UserDetails setUser={setUser} />} />
        <Route path="/users" element={<ShowUsers setUser={setUser} />} />
        <Route
          path="/AdvertisementDetails/:id"
          element={<UserDetails setUser={setUser} />}
        />
        <Route
          path="/Advertisements"
          element={<ShowAdvertisement setUser={setUser} />}
        />
      </Routes>
    </BrowserRouter>
  ) : (
    <Login setUser={setUser} />
  );
};

export default App;
