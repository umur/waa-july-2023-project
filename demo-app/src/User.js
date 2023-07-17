// import React from "react";
// import { useNavigate } from "react-router";
//
// function User(props) {
//   const navigate = useNavigate();
//
//   const onUserClicked = () => {
//     navigate("/UserDetails/" + props.id);
//   };
//
//   return (
//     <div className="userDiv" onClick={onUserClicked}>
//       <h5>
//         <span> First Name: {props.firstName} </span>
//         <br></br>
//         <br></br>
//         <span> Last Name: {props.lastName}</span>
//         <br></br>
//         <br></br>
//         <span> Role :{props.role}</span>
//         <br></br>
//         <br></br>
//         <span> Email :{props.email}</span>
//         <br></br>
//         <br></br>
//       </h5>
//     </div>
//   );
// }
//
// export default User;


import React from "react";
import { useNavigate } from "react-router";

function User(props) {
  const navigate = useNavigate();

  const onUserClicked = () => {
    navigate("/UserDetails/" + props.id);
  };

  return (
      <tr>
        <td>
          {props.id}
        </td>
        <td>
          {props.name}
        </td>
        <td>
          {props.email}
        </td>
        <td>
          {props.role}
        </td>
        <td>
          {props.active}
        </td>
        <td>
          <input type="button" value="Show" onClick={onUserClicked} />
        </td>
      </tr>
  );
}

export default User;
