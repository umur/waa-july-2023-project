import {Navigate} from "react-router-dom";

export default function Dashboards() {
    const useAuth = () => {
        let user = JSON.parse(localStorage.getItem('loggedInUser') || String("{}"))
        return (user && user.accessToken && user.roles);
    }
    const authed = useAuth();

    // we need also add authorization check
    if(authed !== true) {
        return <Navigate to="/sign-in" replace />;
    }
    return (
        <div></div>
    )
}