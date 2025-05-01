package org.fitness.fitnesstracker.dto;

import lombok.Data;

import java.util.List;

@Data
public class GraphDto {

    private List<WorkoutDto> workouts;

    private List<ActivityDto> activities;

}
