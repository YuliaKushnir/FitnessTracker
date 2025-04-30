package org.fitness.fitnesstracker.dto;

import lombok.Data;

@Data
public class StatsDto {

    private long achievedGoals;

    private long notAchievedGoals;

    private int steps;

    private Double distance;

    private int totalCaloriesBurned;

    private int duration;
}
