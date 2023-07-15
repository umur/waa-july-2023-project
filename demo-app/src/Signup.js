import logo from './logo.svg';
import './App.css';


function Signup() {


  const onLoginClick = () =>{

  }

  const onSignUpClick = () =>{

  }


  return (
    <div className='Signup'>


      <br></br><div>Login Screen</div>
      
      <br></br><div>Please write down your credentials</div>


      <div> 
      <br></br><div>Email</div>
        <textarea placeholder='Email' > </textarea><br></br>

        <br></br><div>Password</div>
        <textarea placeholder='Password '> </textarea><br></br>

        <br></br><div>Email</div>
        <textarea placeholder='Name' > </textarea><br></br>

        <br></br><div>Password</div>
        <textarea placeholder='Role '> </textarea><br></br>


        <button onClick={onSignUpClick}>Sign up</button>
        <br></br><br></br><br></br>
        <button onClick={onLoginClick}>Login in</button>

      

      </div>
    </div>
  )

}
export default Signup;