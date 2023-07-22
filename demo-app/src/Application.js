import React from "react";

function Application(props) {
  return (
    <div className="userDiv">
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
