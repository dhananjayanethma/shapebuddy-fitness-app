import React, { useState } from 'react';
import '../../Styles/NavCss.css';

import logo from '../../assets/App_logo_NoBgNav.png';
import userImage from '../../assets/Usericonnav.png';
import userHome from '../../assets/homeiconnav.png';
import userSchedule from '../../assets/schedule.png';
import userPlan from '../../assets/gymplan.png';
import userStatus from '../../assets/status.png';
import userMeal from '../../assets/mealplan.png';
import '../Profile';
import '../Create';



const NavBar = () => {
    return (
    <header className='header'> 
        <div className="container">
            <div className="nav_wrapper">

                <div className="logo">
                    <div className="logo_img">
                        <img src={logo} alt="Shape Buddy"/>
                    </div>
                    <h2>Shape Buddy</h2>
                </div>

                {/* nav right */}

                <div className="nav_right">
                <a href="/home">
                    <img src={userHome} alt="User" className="user_image" />
                </a>
                <a href="/profile">
                    <img src={userSchedule} alt="User" className="user_image" />
                </a>
                <a href="/create">
                    <img src={userPlan} alt="User" className="user_image" />
                </a>
                <a href="/profile">
                    <img src={userStatus} alt="User" className="user_image" />
                </a>
                <a href="/profile">
                    <img src={userMeal} alt="User" className="user_image" />
                </a>
                <a href="/profile">
                    <img src={userImage} alt="User" className="user_image" />
                </a>
                
                </div>
            </div>
        </div>
    </header>
    );

};

export default NavBar;