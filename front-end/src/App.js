import "./App.css";
import { Login } from "./components/Login";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import { Register } from "./components/Register";
import { Home } from "./components/Home";
// import { FacultyEdit } from "./components/FacultyEdit";
import React, { useContext, useState } from "react";
import Dashboard from "./components/Dashboard";
import TestPage from "./components/TestPage";
import ListOfJobs from "./pages/ListOfJobs";
import Latest10jobs from "./pages/Latest10jobs";
import AllStudents from "./pages/AllStudents";
import {FacultyEdit} from "./pages/FacultyEdit";
import JobsAdvertisedPerState from "./pages/JobsAdvertisedPerState";
import NumOfStdsPerCity from "./pages/NumOfStdsPerCity";
import NumOfStdsPerState from "./pages/NumOfStdsPerState";
import TagsWithLocation from "./pages/TagsWithLocation";
import AllComments from "./pages/AllComments";

export const IdContext = React.createContext();
export const AlumniUserContext=React.createContext();

function App() {
  const [id, setId] = useState(null);

  return (
    <BrowserRouter>
      <IdContext.Provider value={id}>
        <Routes>
          <Route path="/" element={<Home />}>
            <Route path="profile" element={<FacultyEdit />} />
            <Route path="dashboard" element={<Dashboard />} />
            <Route path="test" element={<TestPage />} />
            <Route path="students" element={<AllStudents/>}/>
            <Route path="Latest10jobs" element={<Latest10jobs/>}/>
            <Route path="applyforjobs" element={<ListOfJobs/>}/>
            <Route path="JobsAdvertisedPerState" element={<JobsAdvertisedPerState/>}/>
            <Route path="NumOfStdsPerCity" element={<NumOfStdsPerCity/>}/>
            <Route path="NumOfStdsPerState" element={<NumOfStdsPerState/>}/>
            <Route path="TagsWithLocation" element={<TagsWithLocation/>}/>
            <Route path="AllComments" element={<AllComments/>}/>
          </Route>
          <Route path="/login" element={<Login setId={setId}/>} />
          <Route path="/register" element={<Register />} />
          {/* <Route path="/facultyedit" element={<FacultyEdit />} /> */}
        </Routes>
      </IdContext.Provider>
    </BrowserRouter>
  );
}

export default App;
