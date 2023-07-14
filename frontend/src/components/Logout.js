import {Link, useNavigate} from "react-router-dom";
import React from "react";

export default function Logout(props) {
    const navigate = useNavigate();
    const doLogout = () => {
        localStorage.removeItem('loggedInUser');
        //navigate('/sign-in');
        window.location.href = '/sign-in';
    }

    return (
        <li className="nav-item">
            <Link className="nav-link" onClick={doLogout}>
                Logout
            </Link>
        </li>

    )
}