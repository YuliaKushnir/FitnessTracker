package org.fitness.fitnesstracker.services.workout;

import lombok.RequiredArgsConstructor;
import org.fitness.fitnesstracker.dto.WorkoutDto;
import org.fitness.fitnesstracker.models.Workout;
import org.fitness.fitnesstracker.repository.WorkoutRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WorkoutServiceImpl implements WorkoutService {

    private final WorkoutRepository workoutRepository;

    public WorkoutDto postWorkout(WorkoutDto workoutDto) {
        Workout workout = new Workout();

        workout.setDate(workoutDto.getDate());
        workout.setType(workoutDto.getType());
        workout.setDuration(workoutDto.getDuration());
        workout.setCaloriesBurned(workoutDto.getCaloriesBurned());

        return workoutRepository.save(workout).getWorkoutDto();
    }

    public List<WorkoutDto> getWorkouts(){
        List<Workout> workouts = workoutRepository.findAll();

        return workouts.stream().map(Workout::getWorkoutDto).collect(Collectors.toList());
    }

}
