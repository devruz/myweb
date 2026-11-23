package com.devruz.myweb.gym;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
@RestController
public class WorkoutController {
    private final WorkoutService workoutService;

    public WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }
    @GetMapping("/api/workouts")
    public List<Workout> getAll() {
        return  workoutService.getAll();
    }

    @GetMapping("/api/workouts/muscle/{muscle}")
    public List<Workout> getByMuscle(@PathVariable MuscleGroup muscle){
        return workoutService.getByMuscle(muscle);
    }
}
