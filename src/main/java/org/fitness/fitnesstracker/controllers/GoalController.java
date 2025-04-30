package org.fitness.fitnesstracker.controllers;

import lombok.RequiredArgsConstructor;
import org.fitness.fitnesstracker.dto.GoalDto;
import org.fitness.fitnesstracker.models.Goal;
import org.fitness.fitnesstracker.repository.GoalRepository;
import org.fitness.fitnesstracker.services.goal.GoalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("*")
public class GoalController {

    private final GoalService goalService;
    private final GoalRepository goalRepository;

    @PostMapping("/goal")
    public ResponseEntity<?> postGoal(@RequestBody GoalDto goalDto) {
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(goalService.postGoal(goalDto));
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/goals")
    public ResponseEntity<?> getGoals(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(goalService.getGoals());
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/goal/status/{id}")
    public ResponseEntity<?> updateStatus(@PathVariable Long id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(goalService.updateStatus(id));
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}
