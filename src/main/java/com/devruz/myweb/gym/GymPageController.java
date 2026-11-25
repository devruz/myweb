package com.devruz.myweb.gym;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class GymPageController {
    private final WorkoutService workoutService;

    public GymPageController(WorkoutService workoutService){
        this.workoutService = workoutService;
    }

    @GetMapping("/gym")
    public String gymPage(Model model) {
        Map<MuscleGroup, List<Workout>> byMuscle = new LinkedHashMap<>();

        for (MuscleGroup muscle : MuscleGroup.values()) {
            List<Workout> list = workoutService.getByMuscle(muscle);
            if (!list.isEmpty()) {
                byMuscle.put(muscle, list);
            }
        }

        model.addAttribute("byMuscle", byMuscle);
        return "gym";
    }
}
