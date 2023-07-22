import React, {useState} from "react";
import axios from "axios";
import {Navigate} from "react-router-dom";

export default function ResetPassword(props) {
    let user = JSON.parse(localStorage.getItem('loggedInUser') || String("{}"))
    const [data, setData] = useState({
        id:user.id,
        password: '',
        newPassword: '',
        confirmPassword: ''
    })

    const [errorMessage, setErrorMessage] = useState('')

    const handleChange = e => {
        setData(previous => (
            {...previous, [e.target.name]: e.target.value}))
    }

    const resetClicked = (event) => {
        if(!data.password) {
            setErrorMessage("Current password is mandatory");
            return;
        }
        if(!data.newPassword) {
            setErrorMessage("New password is mandatory and must be at least 5 charachters");
            return;
        }
        if(!data.confirmPassword) {
            setErrorMessage("Confirm password is mandatory");
            return;
        }
        if(data.newPassword != data.confirmPassword) {
            setErrorMessage("New password does not match confirm password");
            return;
        }
        setErrorMessage("");
        postResetPassword(data);
    }

    const headers = {
        "Content-Type": "application/json",
        "Authorization": `Bearer  ${user.accessToken}`
    };

    const postResetPassword = async (data) => {
        // send request
        try {
            const result = await axios.put("/user/reset-password", data);
            console.log(result);
            if(result.status > 400) {
                setErrorMessage('Error happened while reset password');
            }
            if(result.status == 200) {
                alert("Password has been successfully reset");
            }
        }catch (e) {
            setErrorMessage('Error happened while reset password')
            if(e && e.response && e.response.status == 400) {
                setErrorMessage('Current password is incorrect');
            }
        }
    }


    const useAuth = () => {
        let user = localStorage.getItem('loggedInUser') ? JSON.parse(localStorage.getItem('loggedInUser')) : false
        return (user != null && user.accessToken != null && user.roles != null);
    }
    const authed = useAuth();

    // we need also add authorization check
    if(authed !== true) {
        return <Navigate to="/sign-in" replace />;
    }

    return (
        <div className="auth-inner">
            <h3>Reset password</h3>
            <span className="error text-danger">{errorMessage}</span>
            <div className="mb-3">
                <label>Current password</label>
                <input
                    value={data.password}
                    onChange={handleChange}
                    name="password"
                    type="password"
                    className="form-control"
                    placeholder="Current password"
                />
            </div>
            <div className="mb-3">
                <label>New password</label>
                <input
                    value={data.newPassword}
                    onChange={handleChange}
                    name="newPassword"
                    type="newPassword"
                    className="form-control"
                    placeholder="New password"
                />
            </div>
            <div className="mb-3">
                <label>Confirm new password</label>
                <input
                    value={data.confirmPassword}
                    onChange={handleChange}
                    name="confirmPassword"
                    type="confirmPassword"
                    className="form-control"
                    placeholder="Confirm new password"
                />
            </div>
            <div className="d-grid">
                <button onClick={resetClicked} className="btn btn-primary">
                    Save
                </button>
            </div>
        </div>
    )
}