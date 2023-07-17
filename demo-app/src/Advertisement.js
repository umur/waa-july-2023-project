import React from "react";
import { useNavigate } from "react-router";

function Advertisement(props) {
  const navigate = useNavigate();

  const onAdverClicked = () => {
    navigate("/AdverDetails/" + props.id);
  };

  return (
    <div className="userDiv" onClick={onAdverClicked}>
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

export default Advertisement;
