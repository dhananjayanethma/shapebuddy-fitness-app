import React from 'react'
import WorkoutStatusView from '../Component/WorkoutStatus/WorkoutStatusView';
import {ViewWorkout} from '../Component/WorkoutPlan/ViewWorkout';

export const MyWorkoutPost = () => {
    return (
        <div className='workoutcontent' >
            <ViewWorkout/>
        </div>
    )
}

export default MyWorkoutPost;