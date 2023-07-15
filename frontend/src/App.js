import './App.css';
import Navbar from './components/navbar/Navbar';
import { BrowserRouter as Router, useRoutes } from "react-router-dom";
// import Login from './components/login/Login';
// import Student from './components/student/Student';
import StudentList from './components/student/StudentList';
import StudentAdd from './components/student/StudentAdd';
import StudentUpdate from './components/student/StudentUpdate';
import NotFound from './components/not-found/NotFound';
import Home from './components/home/Home';

const MyRoutes = () => {
  const routes = useRoutes([
    { path: "/", element: <Home /> },
    { path: "/showStudents", element: <StudentList /> },
    { path: "/createStudents", element: <StudentAdd /> },
    { path: "/updateStudents/:id", element: <StudentUpdate /> },
    { path: "*", element: <NotFound /> },
  ]);
  return routes;
};


function App() {
  return (
    <Router>
    <div className="App">
      <div className="container">
        <Navbar/>
        <div className="content">
          <MyRoutes />
        </div>
      </div>
    </div>
    </Router>
  );
}

export default App;
