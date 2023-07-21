import {Navigate} from "react-router-dom";
// import {useAuth} from "../hooks/useAuth";
import {useState, useEffect} from "react";
import axios from 'axios';

export default function Jobs() {
    let user = localStorage.getItem('loggedInUser') ? JSON.parse(localStorage.getItem('loggedInUser')) : false
    const headers = {
            'Access-Control-Allow-Headers': '*',
            "Access-Control-Allow-Origin": "*",
            "Content-Type": "application/json",
            "Authorization": `Bearer ${user.accessToken}`
    };
    let jobs =  [
        {
            id: '',
            companyName: '',
            description: '',
            benefits: '',
            tags: [],
            state: '',
            city: ''
        }
    ]
    const [searchTerm, setSearchTerm] = useState('')
    const [data, setData] = useState(jobs)
    const [initialJobs, setInitialJobs] = useState(jobs)

    const useAuth = () => {
        return (user != null && user.accessToken != null && user.roles != null);
    }
    const authed = useAuth();

    useEffect(() => {
        getAllJobs();
    }, [])

    const getAllJobs = async () => {
        const result = await axios.get('/api/filter/job-advertisements', {headers : headers});
        if(result.status == 200) {
            console.log("Jobs ", result)
            setInitialJobs(result.data)
            setData(result.data)
        }else
             console.log("Retrieve all jobs failed");
    }

    // we need also add authorization check
    if(authed !== true) {
        return <Navigate to="/sign-in" replace />;
    }

    const tagsList = Array.from(new Set(initialJobs.flatMap((job) => job.tags.map((tag) => tag.name))));

    const handleFilter = () => {
        const filteredData = initialJobs.filter((job) => {
            const lowerCaseSearchTerm = searchTerm.toLowerCase();

            return (
                job.tags.some((tag) => tag.name.toLowerCase().includes(lowerCaseSearchTerm)) ||
                job.state.toLowerCase().includes(lowerCaseSearchTerm) ||
                job.city.toLowerCase().includes(lowerCaseSearchTerm) ||
                job.companyName.toLowerCase().includes(lowerCaseSearchTerm)
            );
        });

        setData(filteredData);
    };

    const handleResetFilter = () => {
        setData(initialJobs);
        setSearchTerm("");
    };

    return (
        <div className="table-container">
            <div className="input-group">
                <input
                    type="text"
                    placeholder="Search by tags, state, city, or company name"
                    value={searchTerm}
                    list="datalistOptions"
                    className="form-control"
                    onChange={(e) => setSearchTerm(e.target.value)}
                />
                <datalist id="datalistOptions">
                    {tagsList.map((tag, index) => (
                        <option key={index} value={tag} />
                    ))}
                </datalist>
                <button className="btn btn-success" onClick={handleFilter}>Filter</button>
                <button className="btn btn-secondary" onClick={handleResetFilter}>Reset Filter</button>
            </div>
            <table className="table table-hover mt-3">
                <thead>
                <tr>
                    <th scope="col">Company</th>
                    <th scope="col">Description</th>
                    <th scope="col">Benefits</th>
                    <th scope="col">State</th>
                    <th scope="col">City</th>
                </tr>
                </thead>
                <tbody>
                {data && data.map((job, index) => (
                    <tr key={index}>
                        <td>{job.companyName}</td>
                        <td>{job.description}</td>
                        <td>{job.benefits}</td>
                        <td>{job.state}</td>
                        <td>{job.city}</td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    )
}