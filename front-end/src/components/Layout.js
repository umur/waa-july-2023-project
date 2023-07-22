import React from 'react'
import Footer from "./Footer";
import Sidebar from "./Sidebar";
import TopBar from "./TopBar";

function Layout({children}) {
  return (
    <div id="page-top">
      {/* <!-- Page Wrapper --> */}
      <div id="wrapper">
        <Sidebar />
        {/* <!-- Content Wrapper --> */}
        <div id="content-wrapper" className="d-flex flex-column">
          {/* <!-- Main Content --> */}
          <div id="content">
            <TopBar />
            {/* <!-- Begin Page Content --> */}
            {/* <div className="container-fluid"></div> */}
           {children}
            <Footer/>
          </div>
        </div>
      </div>
    </div>
  )
}

export default Layout
