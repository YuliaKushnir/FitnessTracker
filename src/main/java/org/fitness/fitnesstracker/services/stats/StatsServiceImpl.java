package org.fitness.fitnesstracker.services.stats;

import lombok.RequiredArgsConstructor;
import org.fitness.fitnesstracker.dto.StatsDto;
import org.fitness.fitnesstracker.repository.ActivityRepository;
import org.fitness.fitnesstracker.repository.GoalRepository;
import org.fitness.fitnesstracker.repository.WorkoutRepository;
import org.springframework.stereotype.Service;

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
}
