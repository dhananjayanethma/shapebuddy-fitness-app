import React from 'react';
import {BrowserRouter, Routes, Route} from "react-router-dom";
import './App.css';
import Login from "./Component/Login";
import Home from "./Component/Home";
import '@fortawesome/fontawesome-free/css/all.min.css';
import Profile from "./Component/Profile";
import NavBar from './Component/NavBar/NavBar';
import Create from './Component/Create';
import AddWorkout from './pages/AddWorkout';
import MyWorkoutPost from './pages/MyWorkoutPost';
import WorkoutContent from './pages/WorkoutContent';
import WorkoutTemplate from './pages/WorkoutTemplate';
import CreateAddWorkout from "./Component/Create/createAddWorkout";
import CreateMyPost from "./Component/Create/createMyPost";
import CreateManageWorkout from "./Component/Create/createManageWorkout";
import CreateTemplate from "./Component/Create/createTemplate";

function App() {
    return (
        <BrowserRouter>
            <NavBar/>
            <Routes>
                <Route path="/" element={<Login/>}/>
                <Route path="/home" element={<Home/>}/>
                <Route path="/profile" element={<Profile/>}/>
                <Route path="/create" element={<Create/>}>
                    <Route path="mypost" element={<CreateMyPost/>}/>
                    <Route path="addworkout" element={<CreateAddWorkout/>}/>
                    <Route path="manageworkout" element={<CreateManageWorkout/>}/>
                    <Route path="template" element={<CreateTemplate/>}/>
                </Route>
                <Route path="/addworkout" element={<AddWorkout/>}/>
                <Route path="/profile" element={<MyWorkoutPost/>}/>
                <Route path="/workoutcontent" element={<WorkoutContent/>}/>
                <Route path="/workouttemplate" element={<WorkoutTemplate/>}/>
            </Routes>
        </BrowserRouter>

    );
}

export default App;
