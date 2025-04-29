package org.fitness.fitnesstracker.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.fitness.fitnesstracker.dto.WorkoutDto;

import java.sql.Date;

@Entity
@Data
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String type;

    private Date date;

    private int duration;

    private int caloriesBurned;

    public WorkoutDto getWorkoutDto(){
        WorkoutDto workoutDto = new WorkoutDto();

        workoutDto.setId(id);
        workoutDto.setType(type);
        workoutDto.setDate(date);
        workoutDto.setDuration(duration);
        workoutDto.setCaloriesBurned(caloriesBurned);

        return workoutDto;
    }

}
