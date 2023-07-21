import logo from "./logo.svg";
import "./App.css";
import { Login } from "./components/Login";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import { Register } from "./components/Register";
import { Header } from "./components/Header";
import { Home } from "./components/Home";
import { FacultyEdit } from "./components/FacultyEdit";
import React, { useContext, useState } from "react";

export const IdContext = React.createContext();

function App() {
  const [id, setId] = useState(null);

  return (
    <BrowserRouter>
      <IdContext.Provider value={id}>
        <Header />
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/login" element={<Login setId={setId}/>} />
          <Route path="/register" element={<Register />} />
          <Route path="/facultyedit" element={<FacultyEdit />} />
        </Routes>
      </IdContext.Provider>
    </BrowserRouter>
  );
}

export default App;
