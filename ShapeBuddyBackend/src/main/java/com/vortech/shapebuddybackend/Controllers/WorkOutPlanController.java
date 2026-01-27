package com.vortech.shapebuddybackend.Controllers;

import com.vortech.shapebuddybackend.Entity.WorkOutPlan;
import com.vortech.shapebuddybackend.Service.WorkOutPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/workoutPlans")
public class WorkOutPlanController {

    @Autowired
    private WorkOutPlanService workOutPlanService;

    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<WorkOutPlan>> getWorkoutPlans() {
        List<WorkOutPlan> workOutPlans = workOutPlanService.findAll();
        return new ResponseEntity<>(workOutPlans, HttpStatus.OK);
    }
    @CrossOrigin
    @GetMapping("/{userId}")
    public ResponseEntity<List<WorkOutPlan>> getWorkoutPlansByUserId(@PathVariable("userId") int userId) {
        List<WorkOutPlan> workOutPlans = workOutPlanService.findByUserId(userId);
        return new ResponseEntity<>(workOutPlans, HttpStatus.OK);
    }
    @CrossOrigin
    @PostMapping
    public ResponseEntity<WorkOutPlan> createWorkoutPlan(@RequestBody WorkOutPlan workOutPlan) {
        WorkOutPlan savedOutPlan = workOutPlanService.save(workOutPlan);
        return new ResponseEntity<>(savedOutPlan, HttpStatus.CREATED);
    }
    @CrossOrigin
    @DeleteMapping("/{workoutPlanId}")
    public ResponseEntity<Void> deleteWorkoutPlan(@PathVariable("workoutPlanId") int workoutPlanId) {
        workOutPlanService.deleteById(workoutPlanId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @CrossOrigin
    @PutMapping("/{workoutPlanId}")
    public ResponseEntity<WorkOutPlan> updateWorkoutPlan(@PathVariable int workoutPlanId, @RequestBody WorkOutPlan updatedWorkoutPlan) {
        Optional<WorkOutPlan> existingWorkoutPlanOptional = workOutPlanService.findById(workoutPlanId);

        if (existingWorkoutPlanOptional.isPresent()) {
            WorkOutPlan existingWorkoutPlan = existingWorkoutPlanOptional.get();
            existingWorkoutPlan.setUserId(updatedWorkoutPlan.getUserId());
            existingWorkoutPlan.setRoutines(updatedWorkoutPlan.getRoutines());
            existingWorkoutPlan.setPlanName(updatedWorkoutPlan.getPlanName());
            existingWorkoutPlan.setDescription(updatedWorkoutPlan.getDescription());
            existingWorkoutPlan.setGoal(updatedWorkoutPlan.getGoal());

            WorkOutPlan savedWorkoutPlan = workOutPlanService.save(existingWorkoutPlan);
            return new ResponseEntity<>(savedWorkoutPlan, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
