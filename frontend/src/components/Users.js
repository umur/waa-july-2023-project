import {Navigate, useNavigate} from "react-router-dom";
import React, {useEffect, useState} from "react";
import axios from "axios";

export default function Users() {

    let loggedInUser = JSON.parse(localStorage.getItem('loggedInUser') || String("{}"))
    let headers = {};
    if(loggedInUser != null && loggedInUser.accessToken !=null && loggedInUser.roles != null) {
        headers['Authorization'] = 'Bearer ' + loggedInUser.accessToken;
    }


    const getUsers = async () => {
        try {
            let result = await axios.get("/admin/all-users", {headers})
            setUsers(result.data);
        } catch (e) {
            return [];
        }
    }

    const [users, setUsers] = useState([])

    useEffect(() => {
        getUsers();
    }, [])

    const putLockUnlock = async (user) => {
        try {
            axios.defaults.headers.common['Authorization'] = 'Bearer ' + loggedInUser.accessToken;
            await axios.put("/admin/lock/" + user.id+ "?locked=" + !user.locked);
            getUsers();
        } catch(e) {
            alert("Error Happened while lock/unlock")
        }
    }

    const handleLock = (user) => {
        putLockUnlock(user);
    }

    const putActiveDeActive = async (user) => {
        try {
            axios.defaults.headers.common['Authorization'] = 'Bearer ' + loggedInUser.accessToken;
            await axios.put("/admin/active/" + user.id + "?active=" + !user.active);
            getUsers();
        } catch(e) {
            alert("Error Happened while lock/unlock")
        }
    }

    const handleActive = (user) => {
        putActiveDeActive(user);
    }

    const navigate = useNavigate()

    const handleResetPassword = (user) => {
        navigate("/reset-password/"+user.id+"/" + user.firstName + ' ' + user.lastName)
    }

    const useAuth = () => {
        let user = localStorage.getItem('loggedInUser') ? JSON.parse(localStorage.getItem('loggedInUser')) : false
        return (user != null && user.accessToken != null && user.roles != null);
    }
    const authed = useAuth();

    if(authed !== true) {
        return <Navigate to="/sign-in" replace />;
    }

    return (
        <div class="usersTable">
            <h2>Users</h2>
            <hr/>
            <table className="table table-striped">
                <thead>
                <tr>
                    <th>Firstname</th>
                    <th>Lastname</th>
                    <th>Email</th>
                    <th>Roles</th>
                    <th>Locked</th>
                    <th>Active</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                {
                    users.map((user) => {
                        return (
                            <tr>
                                <td>{user.firstName}</td>
                                <td>{user.lastName}</td>
                                <td>{user.email}</td>
                                <td>{user.role}</td>
                                <td>{user.locked ? 'yes' : 'no'}</td>
                                <td>{user.active ? 'yes' : 'no'}</td>
                                <td>{user.role.indexOf('ADMIN') != -1 ? '' :
                                <div>
                                    <button className="btn btn-primary"
                                            onClick={() => {handleLock(user)}}>{user.locked ? 'Unlock' : 'Lock'}
                                    </button>
                                    &nbsp;
                                    <button className="btn btn-primary"
                                            onClick={() => {handleActive(user)}}>{user.active ? 'DeActivate' : 'Activate'}
                                    </button>
                                    &nbsp;
                                    <button className="btn btn-primary" onClick={() => {handleResetPassword(user)}}>
                                        Reset password
                                    </button>
                                </div>
                                }</td>
                            </tr>
                        )
                    })
                }
                </tbody>
            </table>
        </div>
    );
}