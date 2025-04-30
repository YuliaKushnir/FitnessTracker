package org.fitness.fitnesstracker.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.fitness.fitnesstracker.dto.GoalDto;

import java.sql.Date;

@Entity
@Data
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private Date startDate;

    private Date endDate;

    private boolean achieved;

    public GoalDto getGoalDto(){
        GoalDto goalDto = new GoalDto();

        goalDto.setId(this.id);
        goalDto.setDescription(this.description);
        goalDto.setStartDate(this.startDate);
        goalDto.setEndDate(this.endDate);
        goalDto.setAchieved(this.achieved);

        return goalDto;
    }

}
