import React, { useEffect, useState } from "react";
import axios from "axios";
import User from "./User";
import Template from "./Template";

export default function ShowUsers() {
  const [users, setUsers] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const getUsers = async () => {
      try {
        const response = await axios.get("/users", {
          headers: {
            "Content-Type": "application/json",
            Accept: "application/json",
            Authorization: `Bearer ${localStorage.getItem("user")}`,
          },
        });
        setUsers(response.data);
        setLoading(false);
      } catch (error) {
        console.log(error);
      }
    };

    getUsers();
  }, []);

  if (false) {
    return <div>Loading...</div>;
  }

  return (
    <div>
      <Template />

      <table>
        <thead>
          <tr>
            <th>User Id</th>
            <th>Name</th>
            <th>Email</th>
            <th>Role</th>
            <th>Active</th>
            <th>Get Info</th>
          </tr>
        </thead>
        <tbody>
          {users.map((user) => (
            <User
              key={user.id}
              id={user.id}
              name={user.name}
              email={user.email}
              role={user.role}
              active={user.active + ""}
            />
          ))}
        </tbody>
      </table>
    </div>
  );
}
