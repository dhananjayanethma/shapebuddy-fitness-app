import React from 'react'
import WorkoutSideNavBar from '../Component/NavBar/WorkoutSideNavBar';
import '../Styles/WorkoutCreate.css';
import MyWorkoutPost from '../pages/MyWorkoutPost';

export const AddWorkout = () => {
  return (
    <div style={{ paddingTop: '50px' }}>
            <div className="workout-dashboard">
            <WorkoutSideNavBar />
            <div className="create-content">
                <MyWorkoutPost />
            </div>

        </div>
        </div>
  )
}

export default AddWorkout;
