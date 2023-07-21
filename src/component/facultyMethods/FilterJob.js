import { useState } from 'react';


export default function FilterJob({ data, handleSearch }) {
  const [searchTerm, setSearchTerm] = useState('');
 

  const handleInputChange = (e) => {
    setSearchTerm(e.target.value);
  };

  

  const handleSearchClick = () => {
    const searchResults = data.filter((job) => {
      return (
      
       job.jobTitle.toLowerCase().includes(searchTerm.toLowerCase()) ||
        job.jobLocation.toLowerCase().includes(searchTerm.toLowerCase()) ||
        job.company.toLowerCase().includes(searchTerm.toLowerCase()) ||
        job.id.toString().includes(searchTerm)
      );
    });

    handleSearch(searchResults);
  };

  return (
    <div className="container">
      <div className="row justify-content-center">
        <div className="col-md-6">
          <br />
          <br />
          <h2 className="text-center">Search for Job</h2>
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
        </div>
      </div>
    </div>
  );
}
