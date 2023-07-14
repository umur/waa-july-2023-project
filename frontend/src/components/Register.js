import React, {useEffect, useState} from 'react';
import axios from 'axios';
import {Navigate} from "react-router-dom";

export default function Register() {

    const [newUserData, setNewUserData] = useState({
        email: '',
        firstname: '',
        lastname: '',
        password: '',
        confirmPassword: ''
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
        if(!newUserData.password) {
            setRegisterUserErrorMessage("Password is mandatory");
            return;
        }
        if(newUserData.password !== newUserData.confirmPassword) {
            setRegisterUserErrorMessage("Password does not match with confirm");
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
            role:'CLIENT'
        }
        // send request
        try {
            const result = await axios.post("/uaa/signup", data);
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
        <div className="auth-inner">
                <h3>Sign Up</h3>
                <span className="error text-danger">{registerUserErrorMessage}</span>
                <div className="mb-3">
                    <label>First name</label>
                    <input
                        value={newUserData.firstname} onChange={handleNewUserChange} name="firstname"
                        type="text"
                        className="form-control"
                        placeholder="First name"
                    />
                </div>
                <div className="mb-3">
                    <label>Last name</label>
                    <input
                        value={newUserData.lastname} onChange={handleNewUserChange} name="lastname"
                        type="text" className="form-control" placeholder="Last name" />
                </div>
                <div className="mb-3">
                    <label>Email address</label>
                    <input
                        value={newUserData.email} onChange={handleNewUserChange} name="email"
                        type="email"
                        className="form-control"
                        placeholder="Enter email"
                    />
                </div>
                <div className="mb-3">
                    <label>Password</label>
                    <input
                        value={newUserData.password} onChange={handleNewUserChange} name="password"
                        type="password"
                        className="form-control"
                        placeholder="Enter password"
                    />
                </div>
                <div className="mb-3">
                    <label>Confirm password</label>
                    <input
                        value={newUserData.confirmPassword} onChange={handleNewUserChange} name="confirmPassword"
                        type="password"
                        className="form-control"
                        placeholder="Enter password again"
                    />
                </div>
                <div className="d-grid">
                    <button onClick={registerButtonClicked} className="btn btn-primary">
                        Sign Up
                    </button>
                </div>
                <p className="forgot-password text-right">
                    Already registered <a href="/sign-in">sign in?</a>
                </p>
        </div>
    )
}
