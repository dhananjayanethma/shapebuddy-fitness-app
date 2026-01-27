import React, { useState } from "react";
import axios from 'axios';
import '../../Styles/createAddWorkout.css'
/* eslint-disable */

const createAddWorkout = () => {
    const [planName, setPlanName] = useState('');
    const [description, setDescription] = useState('');
    const [goal, setGoal] = useState('');
    const [routines, setRoutines] = useState('');

    const handleSubmit = async (event) => {
        event.preventDefault();

        const formData = new FormData();
        formData.append('planName', planName);
        formData.append('description', description);
        formData.append('goal', goal);
        formData.append('routines', routines);

        try {
            const response = await axios.post('http://localhost:8080/api/workoutPlans', formData);

            console.log(response.data);
        } catch (error) {
            console.error(error);
        }
    };

    return (
        <form onSubmit={handleSubmit} className="form">
            <label htmlFor="planName">Plan Name:</label>
            <input
                type="text"
                id="planName"
                value={planName}
                onChange={(event) => setPlanName(event.target.value)}
            />
            <br />
            <label htmlFor="description">Description:</label>
            <textarea
                id="description"
                value={description}
                onChange={(event) => setDescription(event.target.value)}
            />
            <br />
            <label htmlFor="goal">Goal:</label>
            <input
                type="text"
                id="goal"
                value={goal}
                onChange={(event) => setGoal(event.target.value)}
            />
            <br />
            <label htmlFor="routines">Routines:</label>
            <textarea
                id="routines"
                value={routines}
                onChange={(event) => setRoutines(event.target.value)}
            />
            <br />
            <button type="submit">Submit</button>
        </form>
    );
}


export default createAddWorkout;