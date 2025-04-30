package org.fitness.fitnesstracker.services.goal;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.fitness.fitnesstracker.dto.GoalDto;
import org.fitness.fitnesstracker.models.Goal;
import org.fitness.fitnesstracker.repository.GoalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GoalServiceImpl implements GoalService {

    private final GoalRepository goalRepository;

    public GoalDto postGoal(GoalDto goalDto) {
        Goal goal = new Goal();

        goal.setDescription(goalDto.getDescription());
        goal.setStartDate(goalDto.getStartDate());
        goal.setEndDate(goalDto.getEndDate());
        goal.setAchieved(false);

        return goalRepository.save(goal).getGoalDto();
    }

    public List<GoalDto> getGoals(){
        List<Goal> goals = goalRepository.findAll();

        return goals.stream().map(Goal::getGoalDto).collect(Collectors.toList());
    }

    public GoalDto updateStatus(Long id){
        Optional<Goal> goal = goalRepository.findById(id);
        if(goal.isPresent()){
            Goal existingGoal = goal.get();

            existingGoal.setAchieved(true);
            return goalRepository.save(existingGoal).getGoalDto();
        }
        throw new EntityNotFoundException("Goal not found");
    }

}
