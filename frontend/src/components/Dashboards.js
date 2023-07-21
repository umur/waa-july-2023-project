import {Navigate} from "react-router-dom";
import NumberOfStudentsPerState from "./NumberOfStudentsPerState";
import NumberOfStudentsPerCity from "./NumberOfStudentsPerCity";

export default function Dashboards() {
    const useAuth = () => {
        let user = JSON.parse(localStorage.getItem('loggedInUser') || String("{}"))
        return (user != null && user.accessToken != null && user.roles != null);
    }
    const authed = useAuth();

    // we need also add authorization check
    if(authed !== true) {
        return <Navigate to="/sign-in" replace />;
    }
    return (
        <div>
        <div class="usersTable">
            <NumberOfStudentsPerState/>
        </div>
            <div className="usersTable">
                <NumberOfStudentsPerCity/>
            </div>
        </div>
    )
}