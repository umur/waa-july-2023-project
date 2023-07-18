import {Navigate} from "react-router-dom";
import React, {useEffect, useState} from "react";
import axios from "axios";

export default function Profile(props) {
    let user = JSON.parse(localStorage.getItem('loggedInUser') || String("{}"))
    const [userData, setUserData] = useState({
        email: user.email,
        firstname: user.firstName,
        lastname: user.lastName,
        role:user.roles[0],
        title:user.title,
        salary:user.salary,
        major:user.major,
        gpa:user.gpa,
        street:user.street,
        city:user.city,
        zip:user.zip,
        state:user.state
    })

    const [userErrorMessage, setUserErrorMessage] = useState('')

    useEffect(() => {
        console.log('userData', userData)
    }, [userData])

    const handleUserChange = e => {
        setUserData(previous => (
            {...previous, [e.target.name]: e.target.value}))
    }

    const saveButtonClicked = (event) => {
        if(!userData.firstname) {
            setUserErrorMessage("Firstname is mandatory");
            return;
        }
        if(!userData.lastname) {
            setUserErrorMessage("Lastname is mandatory");
            return;
        }
        if(!userData.email) {
            setUserErrorMessage("Email is mandatory");
            return;
        }
        if(userData.role == 'FACULTY' && !userData.title) {
            setUserErrorMessage("Title is mandatory");
            return;
        }
        if(userData.role == 'FACULTY' && !userData.salary) {
            setUserErrorMessage("Salary is mandatory");
            return;
        }
        if(userData.role == 'STUDENT' && !userData.major) {
            setUserErrorMessage("Major is mandatory");
            return;
        }
        if(userData.role == 'STUDENT' && !userData.gpa) {
            setUserErrorMessage("GPA is mandatory");
            return;
        }
        if(!userData.street) {
            setUserErrorMessage("Street is mandatory");
            return;
        }
        if(!userData.city) {
            setUserErrorMessage("City is mandatory");
            return;
        }
        if(!userData.zip) {
            setUserErrorMessage("Zip is mandatory");
            return;
        }
        if(!userData.state) {
            setUserErrorMessage("State is mandatory");
            return;
        }
        setUserErrorMessage("");
        postUserData(userData);
    }

    const postUserData = async (userData) => {
        const data = {
            id:user.id,
            email:userData.email,
            firstName:userData.firstname,
            lastName:userData.lastname,
            role:userData.role,
            title:userData.title,
            salary:userData.salary,
            major:userData.major,
            gpa:userData.gpa,
            address: {
                street: userData.street,
                city: userData.city,
                zip: userData.zip,
                state: userData.state
            }
        }
        // send request
        try {
            let url = "/students";
            if(userData.role == 'FACULTY') {
                url = "/faculties"
            }
            const headers = {
                    'Access-Control-Allow-Headers': '*',
                    "Access-Control-Allow-Origin": "*",
                    "Content-Type": "application/json",
                    "Authorization": `Bearer ${user.accessToken}`
            };
            const result = await axios.put(url, data, {headers});
            if(result.status > 399) {
                setUserErrorMessage('Saving user data failed')
            }
            if(result.status == 200) {
                user.email = userData.email;
                user.firstName = userData.firstname;
                user.lastName = userData.firstname;
                user.name = userData.firstname + ' ' + userData.lastname;
                user.title = userData.title;
                user.salary = userData.salary;
                user.major = userData.major;
                user.gpa = userData.gpa;
                user.street = userData.street;
                user.city = userData.city;
                user.zip = userData.zip;
                user.state = userData.state;
                localStorage.setItem('loggedInUser', JSON.stringify(user));
                props.applyUserDataChange();
                alert('User data has been saved successfully!');
            }
            console.log(result);
        }catch (e) {
            setUserErrorMessage('Saving user data failed')
        }
    }

    const useAuth = () => {
        let user = localStorage.getItem('loggedInUser') ? JSON.parse(localStorage.getItem('loggedInUser')) : false
        return (user != null && user.accessToken != null && user.roles != null);
    }
    const authed = useAuth();

    // we need also add authorization check
    if(authed != true) {
        return <Navigate to="/sign-in" replace />;
    }

    return (
        <div className="regArea container py-5">
            <h3>User profile</h3>
            <h5 className="error text-danger">{userErrorMessage}</h5>
            <div className="row">
                <div className="col-md-10 mx-auto">
                    <div className="form-group row">
                        <div className="col-sm-6">
                            <label>First name</label>
                            <input
                                value={userData.firstname} onChange={handleUserChange} name="firstname"
                                type="text"
                                className="form-control"
                                placeholder="First name"
                            />
                        </div>
                        <div className="col-sm-6">
                            <label>Last name</label>
                            <input
                                value={userData.lastname} onChange={handleUserChange} name="lastname"
                                type="text" className="form-control" placeholder="Last name" />
                        </div>
                    </div>
                    <div className="form-group row">
                        <div className="col-sm-6">
                            <label>Email address</label>
                            <input
                                value={userData.email} onChange={handleUserChange} name="email"
                                type="email"
                                className="form-control"
                                placeholder="Enter email"
                            />
                        </div>
                        <div className="col-sm-6">
                            <label>Student/Faculty</label>
                            <select disabled="true" value={userData.role} className="form-control"
                                    onChange={handleUserChange}
                                    placeholder="Faculty/Student" name="role">
                                <option value="FACULTY">Faculty</option>
                                <option value="STUDENT">Student</option>
                            </select>
                        </div>
                    </div>
                    <div className="form-group row">
                        {userData.role == 'FACULTY' ? (
                                <div className="col-sm-6">
                                    <label>Title</label>
                                    <input
                                        value={userData.title} onChange={handleUserChange} name="title"
                                        type="text" className="form-control" placeholder="Title" />
                                </div>
                            ) :
                            (
                                <div className="col-sm-6">
                                    <label>Major</label>
                                    <input value={userData.major} onChange={handleUserChange} name="major"
                                           type="text" className="form-control" placeholder="Major" />
                                </div>
                            )
                        }
                        {userData.role == 'FACULTY' ? (
                                <div className="col-sm-6">
                                    <label>Salary</label>
                                    <input
                                        value={userData.salary} onChange={handleUserChange} name="salary"
                                        type="text" className="form-control" placeholder="Salary" />
                                </div>
                            ) :
                            (
                                <div className="col-sm-6">
                                    <label>GPA</label>
                                    <input value={userData.gpa} onChange={handleUserChange} name="gpa"
                                           type="text" className="form-control" placeholder="Gpa" />
                                </div>
                            )
                        }
                    </div>
                    <div className="form-group row">
                        <div className="col-sm-6">
                            <label>Street</label>
                            <input
                                value={userData.street} onChange={handleUserChange} name="street"
                                type="text" className="form-control" placeholder="Street" />
                        </div>
                        <div className="col-sm-6">
                            <label>City</label>
                            <input
                                value={userData.city} onChange={handleUserChange} name="city"
                                type="text" className="form-control" placeholder="City" />
                        </div>
                    </div>
                    <div className="form-group row">
                        <div className="col-sm-6">
                            <label>Zip</label>
                            <input
                                value={userData.zip} onChange={handleUserChange} name="zip"
                                type="text" className="form-control" placeholder="Zip" />
                        </div>
                        <div className="col-sm-6">
                            <label>State</label>
                            <input
                                value={userData.state} onChange={handleUserChange} name="state"
                                type="text" className="form-control" placeholder="state" />
                        </div>
                    </div>
                    <div className="form-group row">
                        <div className="col-sm-6">
                        </div>
                        <div className="col-sm-6">
                            <button
                                onClick={saveButtonClicked} className="mybtn btn btn-primary">
                                Save
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}