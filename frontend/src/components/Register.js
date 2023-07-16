import React, {useEffect, useState} from 'react';
import axios from 'axios';
import {Navigate} from "react-router-dom";

export default function Register() {

    const [newUserData, setNewUserData] = useState({
        email: '',
        firstname: '',
        lastname: '',
        role:'STUDENT',
        salary:'',
        gpa:'',
        password: '',
        confirmPassword: '',
        street:'',
        city:'',
        zip:'',
        state:''
    })

    const [registerUserErrorMessage, setRegisterUserErrorMessage] = useState('')

    useEffect(() => {
        console.log('newUserData', newUserData)
    }, [newUserData])

    const handleNewUserChange = e => {
        setNewUserData(previous => (
            {...previous, [e.target.name]: e.target.value}))
    }

    const registerButtonClicked = (event) => {
        if(!newUserData.firstname) {
            setRegisterUserErrorMessage("Firstname is mandatory");
            return;
        }
        if(!newUserData.lastname) {
            setRegisterUserErrorMessage("Lastname is mandatory");
            return;
        }
        if(!newUserData.email) {
            setRegisterUserErrorMessage("Email is mandatory");
            return;
        }
        if(!newUserData.role) {
            setRegisterUserErrorMessage("Faculty/Student is mandatory");
            return;
        }
        if(newUserData.role == 'FACULTY' && !newUserData.title) {
            setRegisterUserErrorMessage("Title is mandatory");
            return;
        }
        if(newUserData.role == 'FACULTY' && !newUserData.salary) {
            setRegisterUserErrorMessage("Salary is mandatory");
            return;
        }
        if(newUserData.role == 'STUDENT' && !newUserData.major) {
            setRegisterUserErrorMessage("Major is mandatory");
            return;
        }
        if(newUserData.role == 'STUDENT' && !newUserData.gpa) {
            setRegisterUserErrorMessage("GPA is mandatory");
            return;
        }
        if(!newUserData.password) {
            setRegisterUserErrorMessage("Password is mandatory");
            return;
        }
        if(newUserData.password !== newUserData.confirmPassword) {
            setRegisterUserErrorMessage("Password does not match with confirm");
            return;
        }
        if(!newUserData.street) {
            setRegisterUserErrorMessage("Street is mandatory");
            return;
        }
        if(!newUserData.city) {
            setRegisterUserErrorMessage("City is mandatory");
            return;
        }
        if(!newUserData.zip) {
            setRegisterUserErrorMessage("Zip is mandatory");
            return;
        }
        if(!newUserData.state) {
            setRegisterUserErrorMessage("State is mandatory");
            return;
        }
        setRegisterUserErrorMessage("");
        postUserRegisterData(newUserData);
    }

    const postUserRegisterData = async (userData) => {
        const data = {
            email:userData.email,
            firstname:userData.firstname,
            lastname:userData.lastname,
            password:userData.password,
            role:userData.role,
            salary:userData.salary,
            gpa:userData.gpa,
            street:userData.street,
            city:userData.city,
            zip:userData.zip,
            state:userData.state
        }
        // send request
        try {
            const result = await axios.post("/uaa/signup", data);
            if(result.status > 399) {
                setRegisterUserErrorMessage('Registering new user failed')
            }
            if(result.status == 200) {
                alert('User has been registered successfully!');
            }
            console.log(result);
        }catch (e) {
            setRegisterUserErrorMessage('Registering new user failed')
        }
    }

    const useAuth = () => {
        let user = localStorage.getItem('loggedInUser') ? JSON.parse(localStorage.getItem('loggedInUser')) : false
        return (user != null && user.accessToken != null && user.roles != null);
    }
    const authed = useAuth();

    // we need also add authorization check
    if(authed == true) {
        return <Navigate to="/" replace />;
    }

    return (
            <div className="regArea container py-5">
                <h3>Sign Up</h3>
                <h5 className="error text-danger">{registerUserErrorMessage}</h5>
                <div className="row">
                    <div className="col-md-10 mx-auto">
                        <div className="form-group row">
                            <div className="col-sm-6">
                                <label>First name</label>
                                <input
                                    value={newUserData.firstname} onChange={handleNewUserChange} name="firstname"
                                    type="text"
                                    className="form-control"
                                    placeholder="First name"
                                />
                            </div>
                            <div className="col-sm-6">
                                <label>Last name</label>
                                <input
                                    value={newUserData.lastname} onChange={handleNewUserChange} name="lastname"
                                    type="text" className="form-control" placeholder="Last name" />
                            </div>
                        </div>
                        <div className="form-group row">
                            <div className="col-sm-6">
                                <label>Email address</label>
                                <input
                                    value={newUserData.email} onChange={handleNewUserChange} name="email"
                                    type="email"
                                    className="form-control"
                                    placeholder="Enter email"
                                />
                            </div>
                            <div className="col-sm-6">
                                <label>Student/Faculty</label>
                                <select value={newUserData.role} className="form-control"
                                        onChange={handleNewUserChange}
                                        placeholder="Faculty/Student" name="role">
                                    <option value="FACULTY">Faculty</option>
                                    <option value="STUDENT">Student</option>
                                </select>
                            </div>
                        </div>
                        <div className="form-group row">
                                {newUserData.role == 'FACULTY' ? (
                                        <div className="col-sm-6">
                                            <label>Title</label>
                                            <input
                                            value={newUserData.title} onChange={handleNewUserChange} name="title"
                                            type="text" className="form-control" placeholder="Title" />
                                        </div>
                                            ) :
                                    (
                                        <div className="col-sm-6">
                                            <label>Major</label>
                                            <input value={newUserData.major} onChange={handleNewUserChange} name="major"
                                            type="text" className="form-control" placeholder="Major" />
                                        </div>
                                    )
                             }
                            {newUserData.role == 'FACULTY' ? (
                                    <div className="col-sm-6">
                                        <label>Salary</label>
                                        <input
                                            value={newUserData.salary} onChange={handleNewUserChange} name="salary"
                                            type="text" className="form-control" placeholder="Salary" />
                                    </div>
                                ) :
                                (
                                    <div className="col-sm-6">
                                        <label>GPA</label>
                                        <input value={newUserData.gpa} onChange={handleNewUserChange} name="gpa"
                                               type="text" className="form-control" placeholder="Gpa" />
                                    </div>
                                )
                            }
                        </div>
                        <div className="form-group row">
                            <div className="col-sm-6">
                                <label>Password</label>
                                <input
                                    value={newUserData.password} onChange={handleNewUserChange} name="password"
                                    type="password"
                                    className="form-control"
                                    placeholder="Enter password"
                                />
                            </div>
                            <div className="col-sm-6">
                                <label>Confirm password</label>
                                <input
                                    value={newUserData.confirmPassword} onChange={handleNewUserChange} name="confirmPassword"
                                    type="password"
                                    className="form-control"
                                    placeholder="Enter password again"
                                />
                            </div>
                        </div>
                        <div className="form-group row">
                            <div className="col-sm-6">
                                <label>Street</label>
                                <input
                                    value={newUserData.street} onChange={handleNewUserChange} name="street"
                                    type="text" className="form-control" placeholder="Street" />
                            </div>
                            <div className="col-sm-6">
                                <label>City</label>
                                <input
                                    value={newUserData.city} onChange={handleNewUserChange} name="city"
                                    type="text" className="form-control" placeholder="City" />
                            </div>
                        </div>
                        <div className="form-group row">
                            <div className="col-sm-6">
                                <label>Zip</label>
                                <input
                                    value={newUserData.zip} onChange={handleNewUserChange} name="zip"
                                    type="text" className="form-control" placeholder="Zip" />
                            </div>
                            <div className="col-sm-6">
                                <label>State</label>
                                <input
                                    value={newUserData.state} onChange={handleNewUserChange} name="state"
                                    type="text" className="form-control" placeholder="state" />
                            </div>
                        </div>
                        <div className="form-group row">
                            <div className="col-sm-6">
                                </div>
                            <div className="col-sm-6">
                                <button
                                        onClick={registerButtonClicked} className="mybtn btn btn-primary">
                                    Save
                                </button>
                            </div>
                        </div>
                        <div className="form-group row">
                            <div className="col-sm-6">
                            </div>
                            <div className="col-sm-6">
                                <p className="forgot-password text-right">
                                    Already registered <a href="/sign-in">sign in?</a>
                                </p>
                            </div>
                        </div>
                </div>
            </div>
        </div>
    )
}
