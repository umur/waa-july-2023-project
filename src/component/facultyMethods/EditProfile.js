import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { Route, Router, useNavigate } from 'react-router-dom';
import Faculty from '../role/Faculty';

export default function EditProfile({ onUpdate }) {
  const [selectedFacultyId, setSelectedFacultyId] = useState('');
  const [name, setName] = useState('');
  const [phone, setPhone] = useState('');
  const [email, setEmail] = useState('');
  const [address, setAddress] = useState('');

  const navigate = useNavigate();

  useEffect(() => {
    if (selectedFacultyId) {
      // Fetch faculty data from the server using the selected facultyId
      axios.get(`http://localhost:8080/faculty/update/${selectedFacultyId}`)
        .then((response) => {  
          console.log(response.data);
          setName(response.data.name);
          setPhone(response.data.phone);
          setEmail(response.data.email);
          setAddress(response.data.address);
        })
        .catch((error) => {
          console.log(error);
        });
    }
  }, [selectedFacultyId]);

  const handleSelectChange = (event) => {
    setSelectedFacultyId(event.target.value);
  };

  const btnSubmit = () => {
    const updatedFacultyData = {
      name: name,
      phone: phone,
      email: email,
      address: address,
    };

    // Make a PUT request to update the faculty data in the database
    axios.put(`http://localhost:8080/faculty/update`, updatedFacultyData)
      .then((response) => {
        console.log("Faculty data updated successfully:", response.data);
        // Call the onUpdate function to notify the parent component (if needed)
        if (onUpdate) {
          onUpdate(response.data);
        }
        // Navigate to another page or perform any other action upon successful update
        navigate('/');
      })
      .catch((error) => {
        console.log("Error updating faculty data:", error);
      });

    navigate('/');
  };

  return (
    <div>
      <h1>Edit Faculty</h1>

      <fieldset style={{ margin: 75 }}>
        <form>
          <div className="form-group">
            <label>Select Faculty ID</label>
            <select
              className="form-control"
              value={selectedFacultyId}
              onChange={handleSelectChange}
            >
              <option value="">Select ID</option>
              <option value="1">1</option>
              <option value="2">2</option>
              <option value="3">3</option>
              <option value="4">4</option>
              <option value="5">5</option>
              <option value="6" >6</option>
              <option value="7">7</option>
              <option value="8">8</option>


              
            </select>

            <label>Faculty name</label>
            <input
              type="text"
              className="form-control"
              placeholder="Enter Faculty name"
              value={name}
              onChange={(event) => setName(event.target.value)}
            />
            {/* Add other input fields for phone, email, and address */}
            <label>Faculty phone</label>
            <input type="text" className="form-control" 
            placeholder="Enter Faculty phone" 
            value={phone}
             onChange={(event) => setPhone(event.target.value)} />
            <label>Faculty email</label>
            <input type="text" className="form-control"
             placeholder="Enter Faculty email" 
             value={email} onChange={(event) => setEmail(event.target.value)} />
            <label>Faculty address</label>

          </div>
          <button type="submit" className="btn btn-primary" onClick={btnSubmit}>
            Submit
          </button>
        </form>
      </fieldset>
    </div>
  );
}
