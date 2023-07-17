import React from "react";
import { useNavigate } from "react-router";

function Application(props) {
  const navigate = useNavigate();

  const onApplicationClicked = () => {
    navigate("/ApplicationDetails/" + props.id);
  };

  return (
    <div className="userDiv" onClick={onApplicationClicked}>
      <span className="first-span">{props.title}</span>
      <hr />
      <span className="other-spans">{props.companyName}</span>
      <br />
      <span className="other-spans">
        {props.state} - {props.city}
      </span>
      <br />
      <span className="other-spans">{props.discription}</span>
    </div>
  );
}

export default Application;
