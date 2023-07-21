import React, {useEffect} from 'react'
import '../node_modules/bootstrap/dist/css/bootstrap.min.css'
import './css/App.css'
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom'
import Login from './components/Login.js'
import SignUp from './components/Register.js'
import Students from './components/Students.js'
import Jobs from './components/Jobs.js'
import Users from './components/Users.js'
import Dashboards from './components/Dashboards.js'
import Profile from './components/Profile.js'
import Home from './components/Home.js'
import {useState} from "react";
import ResetPassword from "./components/ResetPassword";
import axios from "axios";
import ResetPasswordByAdmin from "./components/ResetPasswordByAdmin";
import StudentDetail from './components/StudentDetail'

function App() {
  let [authenticated, setAuthenticated] = useState(() => {
    let user = JSON.parse(localStorage.getItem('loggedInUser') || String("{}"))
    return (user && user.accessToken && user.roles);
  })

  const guestMenus =
      [{title:'Sign in', path:'/sign-in'}, {title:'Sign up', path:'/sign-up'}];
  const loggedInUserMenus = {
      ADMIN:[{title:'Users', path:'/users'},
        {title:'Profile', path:'/profile'},
        {title:'Reset password', path:'/reset-password'}
      ],
      FACULTY:[{title:'Dashboards', path:'/dashboards'},
        {title:'Students', path:'/students'},
        {title:'Profile', path:'/profile'},
        {title:'Reset password', path:'/reset-password'}
      ],
      STUDENT:[{title:'Jobs', path:'/jobs'},
        {title:'Profile', path:'/profile'},
        {title:'Reset password', path:'/reset-password'}
      ]
  };

  let [loggedInUser, setLoggedInUser] = useState({});

  const defaultMenu = () => {
    let menus = guestMenus;
    let user = JSON.parse(localStorage.getItem('loggedInUser') || String("{}"))
    if(user != null && user.accessToken !=null && user.roles != null) {
      setLoggedInUser(user);
      menus = [];
      user.roles.map((item) => {
        menus = [...menus, ...loggedInUserMenus[item]];
      })
    }
    return menus;
  }

  let [menuItems, setMenuItems] = useState(defaultMenu);

  const refreshMenus = () => {
    setAuthenticated(true);
    setMenuItems(defaultMenu());
    console.log();
  }

  const refreshUserData = () => {
    let user = JSON.parse(localStorage.getItem('loggedInUser') || String("{}"));
    setLoggedInUser(user);
  }

  const doLogout = () => {
    localStorage.removeItem('loggedInUser');
    setLoggedInUser({});
    setMenuItems(defaultMenu());
    setAuthenticated(false);
    delete axios.defaults.headers.common['Authorization'];
  }

  return (
    //  <Router>
        <div className="App">
          <nav className="navbar navbar-expand-lg navbar-light fixed-top">
            <div className="container">
              {authenticated ? (
                <Link className="navbar-brand" to={'/profile'}>
                  {loggedInUser.name}
                </Link>
                ) :
                  (
                      <Link className="navbar-brand" to={'/'}>
                        Home
                      </Link>
                  )
              }

              <div className="collapse navbar-collapse" id="navbarTogglerDemo02">
                <ul className="navbar-nav ml-auto">
                  {authenticated ? (
                          <li className="nav-item">
                            <Link className="nav-link" to={'/'}>
                              Home
                            </Link>
                          </li>)
                      : ''
                  }
                  {menuItems.map((menu) => {
                    return (
                        <li className="nav-item">
                        <Link className="nav-link" to={menu.path}>
                          {menu.title}
                        </Link>
                        </li>
                    )
                  })}
                  {authenticated ?
                      (
                          <li className="nav-item">
                            <Link className="nav-link" onClick={doLogout} to="/sign-in">
                              Logout
                            </Link>
                          </li>
                      ) : ''}
                </ul>
              </div>
            </div>
          </nav>
          <div className="auth-wrapper">
            <Routes>
              <Route exact path="/" element={<Home />} />
              <Route path="/sign-in" element={<Login applyUserRole={refreshMenus} />}/>
              <Route path="/sign-up" element={<SignUp />} />
              <Route path="/users" element={<Users />}/>
              <Route path="/profile" element={<Profile applyUserDataChange={refreshUserData}/>}/>
              <Route path="/students" element={<Students />}/>
              <Route path="/students/:id" element={<StudentDetail />}/>
              <Route path="/dashboards" element={<Dashboards />}/>
              <Route path="/jobs" element={<Jobs />}/>
              <Route path="/reset-password" element={<ResetPassword />}/>
              <Route path="/reset-password/:id/:name" element={<ResetPasswordByAdmin />}/>
            </Routes>

          </div>
        </div>
    // </Router>
  )
}

export default App;
