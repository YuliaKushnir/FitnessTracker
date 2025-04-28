package org.fitness.fitnesstracker.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.fitness.fitnesstracker.dto.ActivityDto;

import java.sql.Date;

@Entity
@Data
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date date;

    private int steps;

    private double distance;

    private int caloriesBurned;

    public ActivityDto getActivityDto() {
        ActivityDto activityDto = new ActivityDto();

        activityDto.setId(id);
        activityDto.setDate(date);
        activityDto.setSteps(steps);
        activityDto.setDistance(distance);
        activityDto.setCaloriesBurned(caloriesBurned);

        return activityDto;
    }
}
