import { Link } from "react-router-dom";

function Sidebar() {
  return (
    // <!-- Sidebar -->
    <ul
      className="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
      id="accordionSidebar">
      {/* <!-- Sidebar - Brand --> */}
      <Link
        to="/dashboard"
        className="sidebar-brand d-flex align-items-center justify-content-center">
        <div className="sidebar-brand-icon rotate-n-15">
          <i className="fas fa-laugh-wink"></i>
        </div>
        <div className="sidebar-brand-text mx-3">
          Blue Team <sup>3</sup>
        </div>
      </Link>

      {/* <!-- Divider --> */}
      <hr className="sidebar-divider my-0" />

      {/* <!-- Nav Item - Dashboard --> */}
      <li className="nav-item active">
        <Link to="/dashboard" className="nav-link">
          <i className="fas fa-fw fa-tachometer-alt"></i>
          <span>Dashboard</span>
        </Link>
      </li>

      {/* <!-- Divider --> */}
      <hr className="sidebar-divider" />

      {/* <!-- Heading --> */}
      <div className="sidebar-heading">Jobs</div>

      {/* <!-- Nav Item - Pages Collapse Menu --> */}
      <li className="nav-item">
        <Link to="/Latest10jobs" className="nav-link">
          <i className="fas fa-fw fa-tachometer-alt"></i>
          <span>Latest 10 Jobs</span>
        </Link>
      </li>

      <li className="nav-item">
        <Link to="/JobsAdvertisedPerState" className="nav-link">
          <i className="fas fa-fw fa-tachometer-alt"></i>
          <span>Jobs Advertised Per State</span>
        </Link>
      </li>

      <li className="nav-item">
        <Link to="/TagsWithLocation" className="nav-link">
          <i className="fas fa-fw fa-tachometer-alt"></i>
          <span>Tags With Location</span>
        </Link>
      </li>

      <li className="nav-item">
        <Link to="/applyforjobs" className="nav-link">
          <i className="fas fa-fw fa-tachometer-alt"></i>
          <span>Apply for jobs</span>
        </Link>
      </li>

      {/* <!-- Divider --> */}
      <hr className="sidebar-divider" />

      <div className="sidebar-heading">Comments</div>

      {/* <!-- Nav Item - Pages Collapse Menu --> */}
      <li className="nav-item">
        <Link to="/AllComments" className="nav-link">
          <i className="fas fa-fw fa-tachometer-alt"></i>
          <span>All Comments</span>
        </Link>
      </li>

      <li className="nav-item">
        <Link to="/test" className="nav-link">
          <i className="fas fa-fw fa-tachometer-alt"></i>
          <span>Write Comments</span>
        </Link>
      </li>

      {/* <!-- Divider --> */}
      <hr className="sidebar-divider" />

      {/* <!-- Heading --> */}
      <div className="sidebar-heading">Students</div>

      {/* <!-- Nav Item - Pages Collapse Menu --> */}
      <li className="nav-item">
        <Link to="/students" className="nav-link">
          <i className="fas fa-fw fa-tachometer-alt"></i>
          <span>All Students</span>
        </Link>
      </li>

      <li className="nav-item">
        <Link to="/NumOfStdsPerCity" className="nav-link">
          <i className="fas fa-fw fa-tachometer-alt"></i>
          <span>Num Of Students Per City</span>
        </Link>
      </li>

      <li className="nav-item">
        <Link to="/NumOfStdsPerState" className="nav-link">
          <i className="fas fa-fw fa-tachometer-alt"></i>
          <span>Num Of Students Per State</span>
        </Link>
      </li>

      <li className="nav-item">
        <Link to="/test" className="nav-link">
          <i className="fas fa-fw fa-tachometer-alt"></i>
          <span>Filter Students</span>
        </Link>
      </li>

      {/* <!-- Nav Item - Charts --> */}
      <li className="nav-item">
        <Link className="nav-link" to="charts.html">
          <i className="fas fa-fw fa-chart-area"></i>
          <span>Charts</span>
        </Link>
      </li>

      {/* <!-- Nav Item - Tables --> */}
      <li className="nav-item">
        <Link className="nav-link" to="tables.html">
          <i className="fas fa-fw fa-table"></i>
          <span>Tables</span>
        </Link>
      </li>

      {/* <!-- Divider --> */}
      <hr className="sidebar-divider d-none d-md-block" />

      {/* <!-- Sidebar Toggler (Sidebar) --> */}
      <div className="text-center d-none d-md-inline">
        <button className="rounded-circle border-0" id="sidebarToggle"></button>
      </div>

      {/* <!-- Sidebar Message --> */}
      <div className="sidebar-card d-none d-lg-flex">
        <img
          className="sidebar-card-illustration mb-2"
          src="img/undraw_rocket.svg"
          alt="..."
        />
        <p className="text-center mb-2">
          <strong>SB Admin Pro</strong> is packed with premium features,
          components, and more!
        </p>
        <Link
          className="btn btn-success btn-sm"
          to="https://startbootstrap.com/theme/sb-admin-pro">
          Upgrade to Pro!
        </Link>
      </div>
    </ul>
  );
}

export default Sidebar;
