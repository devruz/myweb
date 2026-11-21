package com.devruz.myweb.gym;

public class Workout {
    private String exercise;
    private MuscleGroup muscleGroup;
    private int sets;
    private int reps;
    private double weightKg;

    public Workout(String exercise, MuscleGroup muscleGroup, int sets, int reps, double weightKg) {
        this.exercise = exercise;
        this.muscleGroup = muscleGroup;
        this.sets = sets;
        this.reps = reps;
        this.weightKg = weightKg;
    }
    public String getExercise() {
        return exercise;
    }
    public void setExercise(String exercise) {
        this.exercise = exercise;
    }
    public int getSets() {
        return sets;
    }
    public void setSets(int sets) {
        this.sets = sets;
    }
    public int getReps() {
        return reps;
    }
    public void setReps(int reps) {
        this.reps = reps;
    }
    public double getWeightKg() {
        return weightKg;
    }
    public void setWeightKg(double weightKg) {
        this.weightKg = weightKg;
    }
    public MuscleGroup getMuscleGroup() {
        return muscleGroup;
    }
    public void setMuscleGroup(MuscleGroup muscleGroup) {
        this.muscleGroup = muscleGroup;
    }

}
