import React from 'react';
import MyPosts from '../../assets/myposts.png';
import AddWorkout from '../../assets/add workouts.png';
import ManageWorkout from '../../assets/manageworkouts.png';
import Templates from '../../assets/template.png';
import userPlan from '../../assets/gymplan.png';
import Logo from '../../assets/App_logo_NoBg.png';

import '../../Styles/WorkoutPlan.css';
import {Route, Routes} from "react-router-dom";
import Create from "../Create";
import Profile from "../Profile";

const WorkoutSideNavBar = () => {
    return (
        <>
            <div className="workoutsidemenu">
                <div className="workout_logo">
                    <h2>Shape Buddy</h2>
                </div>

                <div className="workoutmenu-list">
                    <a href="/create/mypost" className='workoutmenuitem'>
                        <img src={MyPosts} alt="post" className="workout_img"/>
                        My Posts
                    </a>

                    <a href="/create/addworkout" className='workoutmenuitem'>
                        <img src={AddWorkout} alt="workout" className="workout_img"/>
                        Add Workout
                    </a>

                    <a href="/create/manageworkout" className='workoutmenuitem'>
                        <img src={ManageWorkout} alt="manage" className="workout_img"/>
                        Manage Workout
                    </a>

                    <a href="/create/template" className='workoutmenuitem'>
                        <img src={Templates} alt="template" className="workout_img"/>
                        Templates
                    </a>

                </div>
            </div>

        </>
    )
}

export default WorkoutSideNavBar