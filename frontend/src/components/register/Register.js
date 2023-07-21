import SignInImage from '../../assets/undraw_signin1.svg';

const Register = () => {
    return ( 
        <div className="form-signin-body">

            <div className="row">

                <div className="col-lg-6 siginIn-Image-parent">
                    <img className="mb-4" id='signIn-Image' src={SignInImage} alt="sign-in" />
                </div>

                <div className="col-lg-6">
                    <form className="form-signin">

                        <h1 className="h3 mb-3 font-weight-normal">Register</h1>

                        <div className="mb-1">
                            <label htmlFor="inputEmail" className="sr-only">Email address</label>
                            <input type="email" id="inputEmail" className="form-control" required autoFocus />
                        </div>

                        <div className="mb-1">
                            <label htmlFor="inputPassword" className="sr-only">Password</label>
                            <input type="password" id="inputPassword" className="form-control" required />
                        </div>

                        <div className="mb-1">
                        <label htmlFor="employmentStatusInput" className="form-label">Role</label>
                        <select className="custom-select d-block w-100" id="employmentStatusInput">
                            <option value="select one">Select Role</option>
                            <option value="student">Student</option>
                            <option value="faculty">Faculty</option>
                        </select>
                        </div>

                        <div className="checkbox mb-3">
                            <label>
                                <input type="checkbox" value="remember-me" /> Remember me
                            </label>
                        </div>

                        <button className="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>

                        <p className="mt-5 mb-3 text-muted">&copy; Group 007</p>
                    </form>
                </div>
            </div>

        </div>
     );
}
 
export default Register;