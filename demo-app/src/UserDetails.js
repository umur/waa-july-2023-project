import React from 'react';import User from './User';
import { useLocation, useParams } from "react-router"
import axios from "axios";
import { useEffect, useState } from "react";

export default function UserDetails(props) {
   
    const params = useParams();


    const [userState, setUserState] = useState({})

    const getUserById = async (id)=>{
        const result = await axios.get('/api/users/'+id , {
            headers: {
              'Content-Type': 'application/json', 
              'Accept': 'application/json'
            }
          });
        setUserState(result.data);
    }

    useEffect( ()=>{
        getUserById(params.id);
    },[params.id])




    return( <div>  {JSON.stringify(userState)}  </div> )
};
