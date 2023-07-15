import React from "react";
import { useNavigate } from "react-router";

function User(props) {
  const navigate = useNavigate();

  const onUserClicked = () => {
    navigate("/UserDetails/" + props.id);
  };

  return (
    <div className="userDiv" onClick={onUserClicked}>
      <h5>
        <span> First Name: {props.firstName} </span>
        <br></br>
        <br></br>
        <span> Last Name: {props.lastName}</span>
        <br></br>
        <br></br>
        <span> Role :{props.role}</span>
        <br></br>
        <br></br>
        <span> Email :{props.email}</span>
        <br></br>
        <br></br>
      </h5>
    </div>
  );
}

export default User;
