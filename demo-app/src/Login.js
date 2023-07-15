import logo from './logo.svg';
import Navigator from './routes/HomeNavigation'



function Login() {


    const onLoginClick = () =>{
  
    }
  
    const onSignUpClick = () =>{
  
    }
  
  
    return (
      <div className='Login'>
  
  
        <br></br><div>Login Screen</div>
        
        <br></br><div>Please write down your credentials</div>
  
  
        <div> 
          <br></br><div>Email</div>
          <textarea placeholder='Email' > </textarea><br></br>
  
          <br></br><div>Password</div>
          <textarea placeholder='Password '> </textarea><br></br>
  
  
          <button onClick={onLoginClick}>Login in</button>
          <br></br><br></br><br></br>
          <button onClick={onSignUpClick}>Sign up</button>
  
        
  
        </div>
      </div>
    )
  
  }
  export default Login;