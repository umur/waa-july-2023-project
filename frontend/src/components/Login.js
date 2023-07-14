import React, {useEffect, useState} from 'react';
import axios from 'axios';
import {Navigate} from "react-router-dom";

const Login = (props)=>{
    const [user, setUser] = useState({
        email: '',
        password: ''
    })

    const [loginErrorMessage, setLoginErrorMessage] = useState('')

    useEffect(() => {
        console.log('user', user)
    }, [user])

    const handleUserChange = e => {
        setUser(previous => (
            {...previous, [e.target.name]: e.target.value}))
        // if(e.target.name === 'email') {
        //     setUser({password: user.password, email: e.target.value})
        // }
        // if(e.target.name === 'password') {
        //     setUser({password: e.target.value, email: user.email})
        // }
    }

    const loginButtonClicked = (event) => {
        if(!user.email) {
            setLoginErrorMessage("Email is mandatory");
            return;
        }
        if(!user.password) {
            setLoginErrorMessage("Password is mandatory");
            return;
        }
        setLoginErrorMessage("");
        postUserCredentials(user);
    }


    const postUserCredentials = async (userCredentials) => {
        // send request
        try {
            const result = await axios.post("/uaa/signin", userCredentials);
            console.log(result);
            if(result.status > 400) {
                setLoginErrorMessage('Error happened while sign in');
            }
            if(result.status == 200 && result.data && result.data.accessToken) {
                localStorage.setItem('loggedInUser', JSON.stringify(result.data));
                props.applyUserRole();
            }
        }catch (e) {
            setLoginErrorMessage('Invalid user credentials')
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
                <h3>Sign In</h3>
                <span class="error text-danger">{loginErrorMessage}</span>
                <div className="mb-3">
                    <label>Email address</label>
                    <input
                        value={user.email}
                        onChange={handleUserChange}
                        name="email"
                        type="email"
                        className="form-control"
                        placeholder="Enter email"
                    />
                </div>
                <div className="mb-3">
                    <label>Password</label>
                    <input
                        value={user.password}
                        onChange={handleUserChange}
                        name="password"
                        type="password"
                        className="form-control"
                        placeholder="Enter password"
                    />
                </div>
                <div className="d-grid">
                    <button onClick={loginButtonClicked} className="btn btn-primary">
                        Submit
                    </button>
                </div>
        </div>
    )
}

export default Login;