import {Navigate} from "react-router-dom";

export default function Profile() {
    const useAuth = () => {
        let user = localStorage.getItem('loggedInUser') ? JSON.parse(localStorage.getItem('loggedInUser')) : false
        return (user != null && user.accessToken != null && user.roles != null);
    }
    const authed = useAuth();

    // we need also add authorization check
    if(authed != true) {
        return <Navigate to="/sign-in" replace />;
    }

    return (
        <div></div>
    )
}