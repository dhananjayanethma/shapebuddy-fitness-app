package com.vortech.shapebuddybackend.Repository;


import com.vortech.shapebuddybackend.Entity.WorkOutPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkOutPlanRepository extends JpaRepository<WorkOutPlan, Integer> {
    List<WorkOutPlan> findByUserId(int userId);
}
