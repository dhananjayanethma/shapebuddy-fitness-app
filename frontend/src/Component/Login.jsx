import React, {useState, useEffect} from 'react';
import {useNavigate} from 'react-router-dom';
import '../App.css';
import '../Styles/LoginStyle.css';
import './Home.jsx';
import registerImage from '../assets/register.png';
import loginImage from '../assets/login.png';
import axios from 'axios';

function Login() {
    const navigate = useNavigate(); // Initialize useNavigate
    const [isSignUpMode, setIsSignUpMode] = useState(false); // State to track mode

    // Function to handle form submission for login
    const handleLoginSubmit = (event) => {
        const username = event.target.username.value;
        const password = event.target.password.value;

        axios.post('http://localhost:8080/api/auth/login', {
            username,
            password,
        })
            .then(response => {
                console.log(response.data);
                localStorage.setItem("token", response.data['accessToken'])
                localStorage.setItem("user_id", response.data['userId'])
                navigate('/home'); // Navigate to the Home component
                // Handle successful login
            })
            .catch(error => {
                console.error(error);
                // Handle error
            });
        event.preventDefault(); // Prevent default form submission
    };

    // Function to handle form submission for sign-up
    const handleSignUpSubmit = (event) => {
        event.preventDefault();

        const username = event.target.username.value;
        const email = event.target.email.value;
        const password = event.target.password.value;

        axios.post('http://localhost:8080/api/auth/register', {
            username,
            email,
            password,
        })
            .then(response => {
                switchToSignIn();
                // console.log(response.data);
                // navigate('/login'); // Navigate to the Home component
                // Handle successful sign-up
            })
            .catch(error => {
                console.error(error);
                // Handle error
            });
    };

    // Function to switch to sign-up mode
    const switchToSignUp = () => {
        setIsSignUpMode(true);
    };

    // Function to switch to sign-in mode
    const switchToSignIn = () => {
        setIsSignUpMode(false);
    };

    // Use useEffect to add and remove event listeners
    useEffect(() => {
        if (localStorage.getItem('token')) {
            navigate('/home');
        }
        const signInBtn = document.getElementById('sign-in-btn');
        const signUpBtn = document.getElementById('sign-up-btn');

        // Add event listeners for switching modes
        if (signInBtn) {
            signInBtn.addEventListener('click', switchToSignIn);
        }
        if (signUpBtn) {
            signUpBtn.addEventListener('click', switchToSignUp);
        }

        // Cleanup event listeners when component unmounts
        return () => {
            if (signInBtn) {
                signInBtn.removeEventListener('click', switchToSignIn);
            }
            if (signUpBtn) {
                signUpBtn.removeEventListener('click', switchToSignUp);
            }
        };
    }, []); // Empty dependency array ensures effect runs once on mount

    return (
        <div className={`container1 ${isSignUpMode ? 'sign-up-mode' : ''}`}>
            <div className="forms-container">
                <div className="signin-signup">
                    <form className="sign-in-form" onSubmit={handleLoginSubmit}>
                        <h2 className="title">Sign in</h2>
                        <div className="input-field">
                            <i className="fas fa-user"></i>
                            <input type="text" placeholder="Username" name="username"/>
                        </div>
                        <div className="input-field">
                            <i className="fas fa-lock"></i>
                            <input type="password" placeholder="Password" name='password'/>
                        </div>
                        <input type="submit" value="Login" className="btn solid"/>
                        <p className="social-text">Or Sign in with social platforms</p>
                        <div className="social-media">
                            <a href="#" className="social-icon">
                                <i className="fab fa-facebook-f"></i>
                            </a>
                            <a href="#" className="social-icon">
                                <i className="fab fa-google"></i>
                            </a>
                        </div>
                    </form>

                    <form className="sign-up-form" onSubmit={handleSignUpSubmit}>
                        <h2 className="title">Sign up</h2>
                        <div className="input-field">
                            <i className="fas fa-user"></i>
                            <input type="text" placeholder="Username" name="username"/>
                        </div>
                        <div className="input-field">
                            <i className="fas fa-envelope"></i>
                            <input type="email" placeholder="Email" name="email"/>
                        </div>
                        <div className="input-field">
                            <i className="fas fa-lock"></i>
                            <input type="password" placeholder="Password" name="password"/>
                        </div>
                        <input type="submit" className="btn" value="Sign up"/>
                        <p className="social-text">Or Sign up with social platforms</p>
                        <div className="social-media">
                            <a href="#" className="social-icon">
                                <i className="fab fa-facebook-f"></i>
                            </a>
                            <a href="#" className="social-icon">
                                <i className="fab fa-google"></i>
                            </a>
                        </div>
                    </form>
                </div>
            </div>

            <div className="panels-container">
                <div className="panel left-panel">
                    <div className="content">
                        <h3>New here?</h3>
                        <p>
                            Join us to achieve a healthy and productive lifestyle together!
                        </p>
                        <button className="btn transparent" id="sign-up-btn">
                            Sign up
                        </button>
                    </div>
                    <img src={registerImage} className="image" alt="sign up"/>
                </div>
                <div className="panel right-panel">
                    <div className="content">
                        <h3>One of us?</h3>
                        <p>
                            Another healthy adventure with your homies... Be healthy, be in shape.
                        </p>
                        <button className="btn transparent" id="sign-in-btn">
                            Sign in
                        </button>
                    </div>
                    <img src={loginImage} className="image" alt="sign in"/>
                </div>
            </div>
        </div>
    );
}

export default Login;
