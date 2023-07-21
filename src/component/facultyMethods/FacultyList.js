import React, { Component } from 'react';
import axios from 'axios';
import EditProfile from './EditProfile';

class FacultyList extends Component {
  constructor(props) {
    super(props);
    this.state = {
      faculty: [],
      selectedFaculty: null,
      
    };
    this.style = {
      margin: 'auto',
      fontSize: '48px',
      color: 'white',
    };
  }

  componentDidMount() {
    axios
      .get('http://localhost:8080/faculty/getAll')
      .then((response) => {
        this.setState({ faculty: response.data });
      })
      .catch((error) => {
        console.log(error);
      });
  }

  handleUpdate = (facultyId) => {
    // Retrieve the faculty data that needs to be updated based on the faculty ID
    const facultyToUpdate = this.state.faculty.find(
      (faculty) => faculty.id === facultyId
    );

    // Perform navigation programmatically
    this.props.history.push('/edit-profile', {
      faculty: facultyToUpdate,
    });
  };

  render() {
    return (
      <div>
        <nav className="navbar navbar-expand-lg bg-info" data-bs-theme="dark">
          <p style={this.style}>Welcome To Faculty Page</p>
        </nav>

        <br />
        <div className="container">
          <div className="row">
            <table className="table table-striped table-bordered">
              <thead>
                <tr>
                  <th>Faculty ID</th>
                  <th>Faculty Name</th>
                  <th>Faculty Email</th>
                  <th>Faculty Phone</th>
                  <th>Faculty Address</th>
                </tr>
              </thead>
              <tbody>
                {this.state.faculty.map((faculty) => (
                  <tr key={faculty.id}>
                    <td>{faculty.id}</td>
                    <td>{faculty.name}</td>
                    <td>{faculty.email}</td>
                    <td>{faculty.phone}</td>
                    <td>{faculty.address}</td>
                    <td>
                      <button
                        style={{ margin: '10px' }}
                        className="btn btn-info"
                        onClick={() => this.handleUpdate(faculty.id)}
                      >
                        Update
                      </button>
                      <button className="btn btn-danger">Delete</button>
                    </td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        </div>
        {this.state.selectedFaculty && (
          <EditProfile
            faculty={this.state.selectedFaculty}
            onUpdate={() => this.setState({ selectedFaculty: null })}
          />
        )}
      </div>
    );
  }
}

export default FacultyList;
