package com.vortech.shapebuddybackend.Entity;

import jakarta.persistence.*;

@Table
@Entity(name = "workoutplans")
public class WorkOutPlan {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_id")
    private int userId;
    @Column(name = "routines")
    private String routines;
    @Column(name = "plan_name")
    private String planName;
    @Column(name = "description")
    private String description;
    @Column(name = "goal")
    private String goal;

    public WorkOutPlan() {

    }

    public WorkOutPlan(int id, int userId, String routines, String planName, String description, String goal) {
        this.id = id;
        this.userId = userId;
        this.routines = routines;
        this.planName = planName;
        this.description = description;
        this.goal = goal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getRoutines() {
        return routines;
    }

    public void setRoutines(String routines) {
        this.routines = routines;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }
}
