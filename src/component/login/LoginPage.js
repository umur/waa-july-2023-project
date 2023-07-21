import { useState } from 'react';
import ReactDOM from 'react-dom';
import Admin from '../role/Admin';
import Student from '../role/Student';
import Faculty from '../role/Faculty';
import { useNavigate } from 'react-router-dom';

export default function LoginPage() {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const navigate = useNavigate();

  const handleEmailChange = (e) => {
    setEmail(e.target.value);
  };

  const handlePasswordChange = (e) => {
    setPassword(e.target.value);
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log({
      email,
      password,
    });
    setEmail('');
    setPassword('');
  };

  const login = () => {
    if (email === 'admin' && password === 'admin') {
      // ReactDOM.render(<Admin />, document.getElementById('root'));
      navigate('/admin');
    }
    if (email === 'student' && password === 'student') {
      navigate('/student');
      // ReactDOM.render(<Student />, document.getElementById('root'));
    }
    if (email === 'faculty' && password === 'faculty') {
      // ReactDOM.render(<Faculty />, document.getElementById('root'));
      navigate('/faculty');
    }
  };
  const style = {
   
    width:'300px',
    margin: 'auto',
    
  };
  const style1 = {
    
    margin: '10px',
    backgroundColor: 'lightblue',
  };
  

  return (
    <div style={style1}>
      <h1>Login</h1>
      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label>Email</label>
          <input
          style={style}
            type="text"
            className="form-control"
            placeholder="Enter Email"
            value={email}
            onChange={handleEmailChange}
          />
          <label>Password</label>
          <input
          style={style}
            type="password"
            className="form-control"
            placeholder="Enter Password"
            value={password}
            onChange={handlePasswordChange}
          />
        </div>
        <br/>
        <button type="submit" className="btn btn-primary" onClick={login}>
          Submit
        </button>
      </form>
    </div>
  );
}
