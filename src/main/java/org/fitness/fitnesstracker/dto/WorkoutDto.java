package org.fitness.fitnesstracker.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class WorkoutDto {

    private Long id;

    private String type;

    private Date date;

    private int duration;

    private int caloriesBurned;


}
