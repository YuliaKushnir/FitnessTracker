package org.fitness.fitnesstracker.services.workout;

import org.fitness.fitnesstracker.dto.WorkoutDto;

import java.util.List;

public interface WorkoutService {

    WorkoutDto postWorkout(WorkoutDto workoutDto);

    List<WorkoutDto> getWorkouts();

}
