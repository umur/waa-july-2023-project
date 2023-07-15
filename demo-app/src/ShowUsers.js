import User from "./User"
import { useEffect, useState } from "react";
import axios from "axios";

export default function ShowUsers() {


    const initialUsers = [
        {
          id: 1,
          firstName: "User 1",
          lastName: "User 1",
          role: "Role 1",
          email: "User1@user.com",
        },
        {
          id: 2,
          firstName: "User 2",
          lastName: "User 2",
          role: "Role 2",
          email: "User3@user.com",
        },
        {
          id: 3,
          firstName: "User 3",
          lastName: "User 3",
          role: "Role 3",
          email: "User3@user.com",
        },
      ];
    
      const [users, setUsers] = useState(initialUsers);
    
      const getUsers = async () => {
        const result = await axios.get("http://localhost:8080/api/users");
        console.log(result.data);
        setUsers(result.data);
      };
    
      useEffect(() => {
        getUsers();
      }, []);

    return (
        users.map((user) => {

            return (
                <User
                    id={user.id}
                    key={user.id}
                    firstName={user.firstName}
                    lastName={user.lastName}
                    email={user.email}
                    role={user.role}
                />
            )
        })
    )
}