package com.vortech.shapebuddybackend.Service;

import com.vortech.shapebuddybackend.Entity.WorkOutPlan;
import com.vortech.shapebuddybackend.Repository.WorkOutPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkOutPlanService {

    private WorkOutPlanRepository workOutPlanRepository;

    @Autowired
    public WorkOutPlanService(WorkOutPlanRepository workOutPlanRepository) {
        this.workOutPlanRepository = workOutPlanRepository;
    }

    public List<WorkOutPlan> findAll() {
        return this.workOutPlanRepository.findAll();
    }

    public List<WorkOutPlan> findByUserId(int userId) {
        return this.workOutPlanRepository.findByUserId(userId);
    }

    public WorkOutPlan save(WorkOutPlan workOutPlan) {
       return this.workOutPlanRepository.save(workOutPlan);
    }

    public void deleteById(int workoutPlanId) {
        this.workOutPlanRepository.deleteById(workoutPlanId);
    }

    public Optional<WorkOutPlan> findById(int workoutPlanId) {
        return this.workOutPlanRepository.findById(workoutPlanId);
    }
}
