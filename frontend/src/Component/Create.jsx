import React from 'react';
import NavBar from './NavBar/NavBar';
import WorkoutSideNavBar from './NavBar/WorkoutSideNavBar';
import '../Styles/WorkoutCreate.css';
import MyWorkoutPost from '../pages/MyWorkoutPost';
import WorkoutTemplate from '../pages/WorkoutTemplate';
import Profile from './Profile';
import {Outlet, Routes} from "react-router-dom";

const Create = () => {
    return (
        <div style={{paddingTop: '50px'}}>
            <div className="workout-dashboard">
                <WorkoutSideNavBar/>
                <div className="create-content">
                    <MyWorkoutPost/>
                    <div className="row">
                        <br/>
                        <Outlet></Outlet>
                    </div>
                </div>
                {/*<br/>*/}
                {/*<Outlet></Outlet>*/}
            </div>
        </div>
    );
};


export default Create;
