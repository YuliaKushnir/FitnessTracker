package org.fitness.fitnesstracker.services.goal;


import org.fitness.fitnesstracker.dto.GoalDto;

import java.util.List;

public interface GoalService {

    GoalDto postGoal(GoalDto goalDto);

    List<GoalDto> getGoals();

    GoalDto updateStatus(Long id);

}
