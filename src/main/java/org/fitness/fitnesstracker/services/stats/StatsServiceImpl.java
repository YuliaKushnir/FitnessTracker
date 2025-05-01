package org.fitness.fitnesstracker.services.stats;

import lombok.RequiredArgsConstructor;
import org.fitness.fitnesstracker.dto.GraphDto;
import org.fitness.fitnesstracker.dto.StatsDto;
import org.fitness.fitnesstracker.models.Activity;
import org.fitness.fitnesstracker.models.Workout;
import org.fitness.fitnesstracker.repository.ActivityRepository;
import org.fitness.fitnesstracker.repository.GoalRepository;
import org.fitness.fitnesstracker.repository.WorkoutRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StatsServiceImpl implements StatsService {

    private final GoalRepository goalRepository;

    private final ActivityRepository activityRepository;

    private final WorkoutRepository workoutRepository;

    public StatsDto getStats() {
        Long achievedGoals = goalRepository.countAchievedGoals();
        Long notAchievedGoals = goalRepository.countNotAchievedGoals();

        Integer totalSteps = activityRepository.getTotalSteps();
        Double totalDistance = activityRepository.getTotalDistance();
        Integer totalActivityCaloriesBurned = activityRepository.getTotalActivityCalories();

        Integer totalWorkoutDuration = workoutRepository.getTotalDuration();
        Integer totalWorkoutCaloriesBurned = workoutRepository.getTotalCaloriesBurned();

        int totalCaloriesBurned = (totalActivityCaloriesBurned != null ? totalActivityCaloriesBurned : 0) +
                (totalWorkoutCaloriesBurned != null ? totalWorkoutCaloriesBurned : 0);

        StatsDto statsDto = new StatsDto();
        statsDto.setAchievedGoals(achievedGoals != null ? achievedGoals : 0L);
        statsDto.setNotAchievedGoals(notAchievedGoals != null ? notAchievedGoals : 0L);

        statsDto.setSteps(totalSteps != null ? totalSteps : 0);
        statsDto.setDistance(totalDistance != null ? totalDistance : 0.0);
        statsDto.setTotalCaloriesBurned(totalCaloriesBurned);
        statsDto.setDuration(totalWorkoutDuration != null ? totalWorkoutDuration : 0);


        return statsDto;
    }

    public GraphDto getGraphStats(){
        Pageable pageable = PageRequest.of(0, 7);

        List<Workout> workouts = workoutRepository.findLastSevenWorkouts(pageable);
        List<Activity> activities = activityRepository.findLastSevenWorkouts(pageable);

        GraphDto graphDto = new GraphDto();
        graphDto.setWorkouts(workouts.stream().map(Workout::getWorkoutDto).collect(Collectors.toList()));
        graphDto.setActivities(activities.stream().map(Activity::getActivityDto).collect(Collectors.toList()));

        return graphDto;
    }

}
