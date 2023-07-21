import React, { useState, useEffect } from 'react';
import axios from 'axios';

export default function Filter() {
  const [searchTerm, setSearchTerm] = useState('');
  const [data, setData] = useState([]);

  const handleInputChange = (e) => {
    setSearchTerm(e.target.value);
  };

  const handleSearchClick = () => {
    // console.log(searchTerm);
    const results = data.filter((student) =>student.id===searchTerm||
    student.name===searchTerm||student.email===searchTerm||
    student.phone===searchTerm||student.address===searchTerm
    );

    

  };

 
  // const handleSearch = () => {
  //   // console.log(searchResults);
  // };

  useEffect(() => {
    // Fetch student data from the API
    axios.get('http://localhost:8080/student/students/all')
      .then((response) => {
        setData(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  }, [data]);

  return (
    <div className="container">
      <div className="row justify-content-center">
        <div className="col-md-6">
          <br />
          <br />
          <h2 className="text-center">Search for Student</h2>
          <div className="form-group">
            <label htmlFor="searchTerm">Search:</label>
            <input
              type="text"
              id="searchTerm"
              className="form-control"
              value={searchTerm}
              onChange={handleInputChange}
            />
          </div>
          <br />
          <button className="btn btn-primary" onClick={handleSearchClick}>
            Search
          </button>

          <br />
          <br />
{/* 
          { (
            <table className="table table-bordered">
              <thead>
                <tr>
                  <th>ID</th>
                  <th>Name</th>
                  <th>Email</th>
                 
                </tr>
              </thead>
              <tbody>
                {data.map((student) => (
                  <tr key={student.id}>
                    <td>{student.id}</td>
                    <td>{student.name}</td>
                    <td>{student.email}</td>
                    
                  </tr>
                ))}
              </tbody>
            </table>
          )} */}
        </div>
      </div>
    </div>
  );
}
