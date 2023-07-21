import Student from "./Student";
import ReactDOM from 'react-dom';
import React from 'react';

export default function Admin() {
    const activateStudent = () => {
        console.log("Add Job Button Clicked");
        ReactDOM.render(<Student/>, document.getElementById('root'));
    
    }
    return (
        <div>
            <h1>Admin</h1>

            <nav className="navbar navbar-expand-lg navbar-light bg-light">
                <div className="container-fluid">
                    <button type="button" className="btn btn-primary" onClick={activateStudent}>ACtivate Student</button>
                    <button type="button" className="btn btn-primary">Deactivate Student</button>
                    <button type="button" className="btn btn-primary">ACtivate Student</button>
                    <button type="button" className="btn btn-primary">ACtivate Faculty</button>
                    <button type="button" className="btn btn-primary">Deactivate Faculty</button>
                    <button type="button" className="btn btn-primary">Reset Password</button>
                    </div>
                    </nav>
        </div>
    )
}