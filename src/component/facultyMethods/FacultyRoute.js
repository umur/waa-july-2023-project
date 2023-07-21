import React from 'react'
import { BrowserRouter as Router} from 'react-router-dom';
import { Routes, Route } from 'react-router-dom';
import Faculty from '../role/Faculty';

import Filter from './Filter';
import FilterJob from './FilterJob';
import Register from './RegisterToSystem';
import ResetPassword from './ResetPassword';
import StudentList from '../studentmethods/StudentList';
import EditProfile from './EditProfile';
import Admin from '../role/Admin';
import Student from '../role/Student';
import LoginPage from '../login/LoginPage';
import Edit from '../studentmethods/Edit';
import AddJob from '../studentmethods/AddJob';
import AddWorkExperience from '../studentmethods/AddWorkExperience';
import WriteComment from './WriteComment';



export default function FacultyRoute() {
        return (
            <div>
                 
      <Routes>
        <Route path="/" element={<LoginPage/>} />
      <Route path="/admin" element={<Admin />} />
      <Route path="/student" element={<Student />} />
      <Route path="/faculty" element={<Faculty />} />

      

      <Route path="/addwork" element={<AddWorkExperience />} />
        <Route path="/editjob" element={<Edit/>} />
        <Route path="/editprofile" element={<EditProfile />} />
        <Route path="/filter-student" element={<Filter />} />
        <Route path="/filter-job" element={<FilterJob />} />
        <Route path="/register" element={<Register />} />
        <Route path="/resetpassword" element={<ResetPassword />} />
        <Route path="/studentlist" element={<StudentList />} />
        <Route path="/writecomment" element={<WriteComment />} />
    

        
      </Routes>
   
                </div>
        )
    }