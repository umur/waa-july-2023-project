import React, { useEffect, useState } from "react";
import { useParams } from "react-router";
import axios from "axios";
import Template from "./Template";

function UserDetails(props) {
  const params = useParams();
  const [userState, setUserState] = useState(null);

  useEffect(() => {
    const getUserById = async (id) => {
      const result = await axios.get(`/users/${id}`, {
        headers: {
          "Content-Type": "application/json",
          Accept: "application/json",
        },
      });
      setUserState(result.data);
    };

    getUserById(params.id);
  }, [params.id]);

  if (!userState) {
    return <div>Loading...</div>;
  }

  const userData = {
    id: userState.id,
    name: userState.name,
    image: userState.image_url,
    username: userState.username,
    email: userState.email,
    state: userState.state,
    city: userState.city,
    major: userState.major,
    cv: userState.cv_url,
    role: userState.role,
    logs: userState.logs,
    experiences: userState.experiences,
    givenComments: userState.givenComments,
    receivedComments: userState.receivedComments,
    enabled: String(userState.enabled),
    active: String(userState.active),
    deleted: String(userState.deleted),
  };

  return (
    <Template {...props}>
      <div className="user-card">
        <div className="user-info">
          <h2 className="user-name">{userData.name}</h2>
          <img className="user-image" src={userData.image} alt="User" />
          <button style={{ display: "block" }}>Add/Change Photo</button>
          <p className="user-details">Name: {userData.name}</p>
          <p className="user-details">Id#: {userData.id}</p>
          <p className="user-details">Username: {userData.username}</p>
          <p className="user-details">Email: {userData.email}</p>
          <p className="user-details">State: {userData.state}</p>
          <p className="user-details">City: {userData.city}</p>
          <p className="user-details">Major: {userData.major}</p>
          <a
            className="user-cv"
            href={userData.cv}
            target="_blank"
            rel="noopener noreferrer"
          >
            View CV
          </a>
        </div>

        <div className="user-logs">
          <h3 className="section-title">Logs</h3>
          <ul>
            {userData.logs.map((log) => (
              <li key={log.id}>{log.description}</li>
            ))}
          </ul>
        </div>

        <div className="user-experiences">
          <h3 className="section-title">Experiences</h3>
          <ul>
            {userData.experiences.map((experience) => (
              <li key={experience.id}>
                {experience.role} at {experience.companyName}
              </li>
            ))}
          </ul>
        </div>

        <div className="user-comments">
          <h3 className="section-title">Comments</h3>
          <div className="comment-section">
            <h4>Given Comments</h4>
            <ul>
              {userData.givenComments.map((comment) => (
                <li key={comment.id}>{comment.comment}</li>
              ))}
            </ul>
          </div>
          <div className="comment-section">
            <h4>Received Comments</h4>
            <ul>
              {userData.receivedComments.map((comment) => (
                <li key={comment.id}>{comment.comment}</li>
              ))}
            </ul>
            <button>Add Comment</button>
          </div>
        </div>
      </div>
    </Template>
  );
}

export default UserDetails;
