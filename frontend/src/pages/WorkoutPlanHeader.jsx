import React from 'react';
import Search from '../assets/workout-search.png';

const WorkoutPlanHeader = () => {
    return (
    <div className='workout-plan-content-header'>
      <h1 className="workout-header-title">WorkoutPlan</h1>
      <div className="header-activity">
        <div className="workout-search-box">
        <input type="text" placeholder="Search for Posts" />
        <img src={Search} alt="search" className="workout-search-icon" />
      </div>
      </div>
    </div>
    );
};

export default WorkoutPlanHeader;