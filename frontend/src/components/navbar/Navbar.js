import { Link } from "react-router-dom";

const Navbar = () => {
  return (
    <>
      <div className="container">
        <header className="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
          <Link to="/"
            className="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
            <span className="fs-4">Alumni Management Portal</span>
          </Link>

          <ul className="nav nav-pills">
            <li className="nav-item nav-link">
              <Link to="/" className="nav-link">
                Show Students
              </Link>
            </li>
            <li className="nav-item nav-link">
              <Link to="/createStudents" className="nav-link">
                Add new Student
              </Link>
            </li>
            <li className="nav-item nav-link">
              <Link to="/" className="nav-link">
                Show Faculties
              </Link>
            </li>
            <li className="nav-item nav-link">
              <Link to="/" className="nav-link">
                Add new Faculty
              </Link>
            </li>
            <li className="nav-item nav-link">
              <Link to="http://localhost:8080/swagger-ui/index.html" target="_blank" className="nav-link">
                Docs
              </Link>
            </li>
          </ul>
        </header>
      </div>
    </>
  );
};

export default Navbar;
