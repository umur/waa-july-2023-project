import {Navigate} from "react-router-dom";
// import {useAuth} from "../hooks/useAuth";
import {useState, useEffect} from "react";
import axios from 'axios';

export default function Students() {
    let user = localStorage.getItem('loggedInUser') ? JSON.parse(localStorage.getItem('loggedInUser')) : false
    const headers = {
            'Access-Control-Allow-Headers': '*',
            "Access-Control-Allow-Origin": "*",
            "Content-Type": "application/json",
            "Authorization": `Bearer ${user.accessToken}`
    };
    let students =  [
        {
            id: '',
            major: '',
            firstName: '',
            lastName: '',
            address: {street : '', zip: '', city: '', state: ''},
            gpa: '',
        }
    ]

    const [searchTerm, setSearchTerm] = useState('')
    const [data, setData] = useState(students)
    const [initialStudents, setInitialStudents] = useState(students)
    const useAuth = () => {
        return (user != null && user.accessToken != null && user.roles != null);
    }
    const authed = useAuth();

    useEffect(() => {
        getAllStudents();
    }, [])

    const getAllStudents = async () => {
        const result = await axios.get('/faculties/filter/students', {headers : headers});
        if(result.status == 200) {
            console.log("Studends ", result)
            setInitialStudents(result.data)
            setData(result.data)
        }else
             console.log("Retrieve all students failed");
    }

    const handleFilter = () => {
        const filteredData = initialStudents.filter((student) => {
            const lowerCaseSearchTerm = searchTerm.toLowerCase();
            return (
                student.address.state.toLowerCase().includes(lowerCaseSearchTerm) ||
                student.address.city.toLowerCase().includes(lowerCaseSearchTerm) ||
                student.major.toLowerCase().includes(lowerCaseSearchTerm) ||
                student.firstName.toLowerCase().includes(lowerCaseSearchTerm) ||
                student.lastName.toLowerCase().includes(lowerCaseSearchTerm) ||
                student.id.toString().includes(lowerCaseSearchTerm)
            );
        });
        setData(filteredData);
    };

    // Reset filter and show all students
    const handleResetFilter = () => {
        setData(initialStudents);
        setSearchTerm("");
    };

    // we need also add authorization check
    if(authed !== true) {
        return <Navigate to="/sign-in" replace />;
    }
    return (
        <div className="table-container">
            <div className="input-group">
                <input
                    type="text"
                    placeholder="Search students by id, state, city, or name"
                    value={searchTerm}
                    className="form-control"
                    onChange={(e) => setSearchTerm(e.target.value)}
                />
                <button className="btn btn-success" onClick={handleFilter}>Filter</button>
                <button className="btn btn-secondary" onClick={handleResetFilter}>Reset Filter</button>
            </div>
            <table className="table table-hover mt-3">
                <thead>
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Major</th>
                    <th scope="col">Name</th>
                    <th scope="col">State</th>
                    <th scope="col">City</th>
                </tr>
                </thead>
                <tbody>
                {data && data.map((student, index) => {
                    return (
                        <tr key={index}>
                            <td>{student.id}</td>
                            <td>{student.major}</td>
                            <td>{student.firstName + ' ' + student.lastName}</td>
                            <td>{student.address.state}</td>
                            <td>{student.address.city}</td>
                        </tr>
                    )
                })}
                </tbody>
            </table>
        </div>
    )
}