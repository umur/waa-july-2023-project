import { createStackNavigator } from 'react-navigation-stack';
import { createAppContainer } from 'react-navigation';
import SignUpScreen from  '../Signup';
import LoginScreen from  '../Login';


const screens = {
    LoginScreen:{
        screen: LoginScreen
    },
    SignUpScreen:{
        screen:SignUpScreen
    }
}

const homeStack = createStackNavigator (screens);

export default createAppContainer(homeStack);