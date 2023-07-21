import './App.css';
import Student from './component/role/Student';
import LoginPage from './component/login/LoginPage';
import React from 'react';
import Admin from './component/role/Admin';
import Faculty from './component/role/Faculty';
import { BrowserRouter as Router} from 'react-router-dom';
import { Routes, Route } from 'react-router-dom';
import FacultyRoute from './component/facultyMethods/FacultyRoute';



function App() {

  
  
  return (
    <div className="App">
      
  
   
   <FacultyRoute />

  
    
    </div>
  );
}

export default App;
