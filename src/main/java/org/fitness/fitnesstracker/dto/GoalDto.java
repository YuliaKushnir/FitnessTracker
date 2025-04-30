package org.fitness.fitnesstracker.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class GoalDto {

    private Long id;

    private String description;

    private Date startDate;

    private Date endDate;

    private boolean achieved;
}
