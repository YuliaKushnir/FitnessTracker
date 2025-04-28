package org.fitness.fitnesstracker.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class ActivityDto {

    private Long id;

    private Date date;

    private int steps;

    private double distance;

    private int caloriesBurned;
}
