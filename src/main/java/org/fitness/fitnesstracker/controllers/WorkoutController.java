package org.fitness.fitnesstracker.controllers;

import lombok.RequiredArgsConstructor;
import org.fitness.fitnesstracker.dto.WorkoutDto;
import org.fitness.fitnesstracker.repository.WorkoutRepository;
import org.fitness.fitnesstracker.services.workout.WorkoutService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("*")
public class WorkoutController {

    private final WorkoutService workoutService;

    @PostMapping("/workout")
    public ResponseEntity<?> postWorkout(@RequestBody WorkoutDto workoutDto) {
        try{
            return ResponseEntity.ok(workoutService.postWorkout(workoutDto));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/workouts")
    public ResponseEntity<?> getAllWorkouts(){
        try{
            return ResponseEntity.ok(workoutService.getWorkouts());
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}
