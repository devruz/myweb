package com.devruz.myweb.gym;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class WorkoutService {
    private final List<Workout> workouts = new ArrayList<>();

    public WorkoutService() {

        workouts.add(new Workout("Bench press", MuscleGroup.CHEST, 3, 12, 50.0));
        workouts.add(new Workout("Lever inc chest press", MuscleGroup.CHEST, 3, 12, 30.0));
        workouts.add(new Workout("Cable crossover", MuscleGroup.CHEST, 3, 12, 15.0));
        workouts.add(new Workout("Smith mac inc press", MuscleGroup.CHEST, 3, 12, 40.0));
        workouts.add(new Workout("Peck dec fly", MuscleGroup.CHEST, 3, 12, 30.0));
        workouts.add(new Workout("Decline dumbbell press", MuscleGroup.CHEST, 3, 12, 15.0));

        workouts.add(new Workout("Seated dumbbell press", MuscleGroup.SHOULDERS, 3, 12, 15.0));
        workouts.add(new Workout("Lateral raise", MuscleGroup.SHOULDERS, 3, 12, 10.0));
        workouts.add(new Workout("Bent over reverse fly", MuscleGroup.SHOULDERS, 3, 12, 10.0));
        workouts.add(new Workout("Front raises", MuscleGroup.SHOULDERS, 3, 12, 10.0));
        workouts.add(new Workout("Barbell standing press", MuscleGroup.SHOULDERS, 3, 12, 10.0));

        workouts.add(new Workout("Dumbbell shrugs", MuscleGroup.TRAPS, 3, 17, 20.0));
        workouts.add(new Workout("Barbell shrugs", MuscleGroup.TRAPS, 3, 17, 40.0));

        workouts.add(new Workout("Cable pushdown", MuscleGroup.TRICEPS, 3, 12, 40.0));
        workouts.add(new Workout("Dumbbell seated triceps extension", MuscleGroup.TRICEPS, 3, 12, 15.0));
        workouts.add(new Workout("Kickback", MuscleGroup.TRICEPS, 3, 12, 15.0));
        workouts.add(new Workout("Decline triceps extension", MuscleGroup.TRICEPS, 3, 12, 20.0));

        workouts.add(new Workout("Biceps Curl", MuscleGroup.BICEPS, 3, 12, 12.0));
        workouts.add(new Workout("Hammer Curl", MuscleGroup.BICEPS, 3, 12, 12.0));
        workouts.add(new Workout("Barbell Curl", MuscleGroup.BICEPS, 3, 12, 30.0));
        workouts.add(new Workout("Incline dumbbell Curl", MuscleGroup.BICEPS, 3, 12, 12.0));

        workouts.add(new Workout("Straight arm crunch", MuscleGroup.ABS, 3, 12, 20.0));
        workouts.add(new Workout("V-up", MuscleGroup.ABS, 3, 12, 20.0));
        workouts.add(new Workout("Russian twist", MuscleGroup.ABS, 3, 12, 20.0));
        workouts.add(new Workout("Sit-up", MuscleGroup.ABS, 3, 12, 20.0));

        workouts.add(new Workout("Barbell row", MuscleGroup.BACK, 3, 12, 40.0));
        workouts.add(new Workout("Seated pull", MuscleGroup.BACK, 3, 12, 60.0));
        workouts.add(new Workout("Lateral pull down", MuscleGroup.BACK, 3, 12, 60.0));
        workouts.add(new Workout("Pull ups", MuscleGroup.BACK, 3, 12, 10.0));

        workouts.add(new Workout("Squat", MuscleGroup.GLUTES, 3, 12, 45.0));
        workouts.add(new Workout("Deadlift", MuscleGroup.GLUTES, 3, 12, 80.0));
        workouts.add(new Workout("Deficit reverse lunges", MuscleGroup.GLUTES, 3, 12, 15.0));

        workouts.add(new Workout("Leg press", MuscleGroup.HAMSTRINGS, 3, 12, 120.0));
        workouts.add(new Workout("Leg extensions", MuscleGroup.HAMSTRINGS, 3, 12, 40.0));
        workouts.add(new Workout("Hamstring curls", MuscleGroup.HAMSTRINGS, 3, 12, 40.0));
        workouts.add(new Workout("One leg squat", MuscleGroup.HAMSTRINGS, 3, 12, 40.0));

        workouts.add(new Workout("Seated calf raises", MuscleGroup.CALVES, 3, 12, 40.0));
        workouts.add(new Workout("Standing calf raises", MuscleGroup.CALVES, 5, 12, 40.0));

    }
}