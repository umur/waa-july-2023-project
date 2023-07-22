import {Navigate} from "react-router-dom";
import React, {useEffect, useState} from "react";
import axios from "axios";
import {useAuth} from "../hooks/useAuth";
import { useParams } from "react-router-dom";

export default function StudentDetail(props) {
    const params = useParams()
    const id = params.id
    //    get user Detail with api
    let user = JSON.parse(localStorage.getItem('loggedInUser') || String("{}"))
    const headers = {
        'Access-Control-Allow-Headers': '*',
        "Access-Control-Allow-Origin": "*",
        "Content-Type": "application/json",
        "Authorization": `Bearer ${user.accessToken}`
    };
    const [userData, setUserData] = useState({
            id: '',
            major: '',
            firstName: '',
            lastName: '',
            address: {street : '', zip: '', city: '', state: ''},
            gpa: '',
    })
    const [comment, setComment] = useState('')
    const [comments, setComments] = useState([{
        comment: 'test',
        commentedAt: '12.12.2023'
    }])

    useEffect(() => {
        getStudent()
        getComments()
    }, [])

    const getStudent = async () => {
        const result = await axios.get('/faculties/filter/students', {headers : headers, params: { id: id }});
        if(result.status == 200) {
            setUserData(result.data[0])
        } else
             console.log("Retrieve student failed");
    }

    const getComments = async () => {
        const result = await axios.get('/faculties/student/comments', {headers : headers, params: { id: id }});
        if(result.status == 200) {
            setComments(result.data)
        } else
            console.log("Retrieve comments failed");
    }

    const handleSubmitComment = async () =>{
        const result = await axios.post(
            '/faculties/student/comment',
            {comment, studentId: id},
            { headers }
        );

        if (result.status === 200) {
            getStudent()
            console.log('Comment posted successfully');
        } else {
            console.log('Posting comment failed');
        }
    }

    const authed = useAuth();

    // we need also add authorization check
    if(authed != true) {
        return <Navigate to="/sign-in" replace />;
    }

    return (
        <div className="regArea container py-5">
            <h3>{userData.firstName} {userData.lastName}</h3>
            <div className="row">
                <div className="col-md-10 mx-auto">
                    <div className="form-group row">
                        <div className="col-sm-6">
                            <label>First name</label>
                            <input
                                disabled = {true}
                                value={userData.firstName} name="firstname"
                                type="text"
                                className="form-control"
                                placeholder="First name"
                            />
                        </div>
                        <div className="col-sm-6">
                            <label>Last name</label>
                            <input
                                disabled = {true}
                                value={userData.lastName} name="lastname"
                                type="text" className="form-control" placeholder="Last name" />
                        </div>
                    </div>
                    <div className="form-group row">
                        <div className="col-sm-6">
                            <label>Email address</label>
                            <input
                                disabled = {true}
                                value={userData.email} name="email"
                                type="email"
                                className="form-control"
                                placeholder="Enter email"
                            />
                        </div>
                        <div className="col-sm-6">
                            <label>Id</label>
                            <input
                                disabled = {true}
                                value={userData.id} name="id"
                                type="text"
                                className="form-control"
                                placeholder="Id"
                            />
                        </div>
                    </div>
                    <div className="form-group row">
                        {userData.role == 'FACULTY' ? (
                                <div className="col-sm-6">
                                    <label>Title</label>
                                    <input
                                        disabled = {true}
                                        value={userData.title} name="title"
                                        type="text" className="form-control" placeholder="Title" />
                                </div>
                            ) :
                            (
                                <div className="col-sm-6">
                                    <label>Major</label>
                                    <input  disabled = {true} value={userData.major} name="major"
                                           type="text" className="form-control" placeholder="Major" />
                                </div>
                            )
                        }
                        {userData.role == 'FACULTY' ? (
                                <div className="col-sm-6">
                                    <label>Salary</label>
                                    <input
                                        disabled = {true}
                                        value={userData.salary} name="salary"
                                        type="text" className="form-control" placeholder="Salary" />
                                </div>
                            ) :
                            (
                                <div className="col-sm-6">
                                    <label>GPA</label>
                                    <input  disabled = {true} value={userData.gpa} name="gpa"
                                           type="text" className="form-control" placeholder="Gpa" />
                                </div>
                            )
                        }
                    </div>
                    <div className="form-group row">
                        <div className="col-sm-6">
                            <label>Street</label>
                            <input
                                disabled = {true}
                                value={userData.address.street} name="street"
                                type="text" className="form-control" placeholder="Street" />
                        </div>
                        <div className="col-sm-6">
                            <label>City</label>
                            <input
                                disabled = {true}
                                value={userData.address.city} name="city"
                                type="text" className="form-control" placeholder="City" />
                        </div>
                    </div>
                    <div className="form-group row">
                        <div className="col-sm-6">
                            <label>Zip</label>
                            <input
                                disabled = {true}
                                value={userData.address.zip} name="zip"
                                type="text" className="form-control" placeholder="Zip" />
                        </div>
                        <div className="col-sm-6">
                            <label>State</label>
                            <input
                                disabled = {true}
                                value={userData.address.state} name="state"
                                type="text" className="form-control" placeholder="state" />
                        </div>
                    </div>
                    <br/>
                    {comments?.map((comment, index)=>(
                        <p key={index} className="text-start">{comment.comment}</p>
                    ))}
                    <div className="form-group row ">
                        <div className="col-sm-12">
                            <label>Comment</label>
                            <textarea onChange={(e)=> setComment(e.target.value)} className="form-control" placeholder="Leave a comment here"/>
                        </div>
                     </div>
                     <br/>
                     <button onClick={handleSubmitComment} className = "btn btn-primary">Save</button>
                </div>
            </div>
        </div>
    )
}