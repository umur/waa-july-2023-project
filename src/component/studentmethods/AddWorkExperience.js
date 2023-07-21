import React, { useState } from 'react';

export default function AddWorkExperience(){
  const [companyName, setCompanyName] = useState('');
  const [position, setPosition] = useState('');
  const [startDate, setStartDate] = useState('');
  const [endDate, setEndDate] = useState('');

  const handleCompanyNameChange = (e) => {
    setCompanyName(e.target.value);
  };

  const handlePositionChange = (e) => {
    setPosition(e.target.value);
  };

  const handleStartDateChange = (e) => {
    setStartDate(e.target.value);
  };

  const handleEndDateChange = (e) => {
    setEndDate(e.target.value);
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    // Perform further actions with the entered work experience details
    console.log({
      companyName,
      position,
      startDate,
      endDate
    });

    // Reset the form fields
    setCompanyName('');
    setPosition('');
    setStartDate('');
    setEndDate('');
  };
  const style = {
    margin: 75,
   
    };

  return (
    <div>
      <h2>Add Work Experience</h2>
      <form onSubmit={handleSubmit} style={style}>
        <div>
          <label htmlFor="companyName">Company Name:</label>
          <input type="text" id="companyName" value={companyName} onChange={handleCompanyNameChange} required />
        </div>
        <div>
          <label htmlFor="position">Position:</label>
          <input type="text" id="position" value={position} onChange={handlePositionChange} required />
        </div>
        <div>
          <label htmlFor="startDate">Start Date:</label>
          <input type="date" id="startDate" value={startDate} onChange={handleStartDateChange} required />
        </div>
        <div>
          <label htmlFor="endDate">End Date:</label>
          <input type="date" id="endDate" value={endDate} onChange={handleEndDateChange} required />
        </div>
        <button type="submit">Add</button>
      </form>
    </div>
  );
};


