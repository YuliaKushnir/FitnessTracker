package org.fitness.fitnesstracker.controllers;

import lombok.RequiredArgsConstructor;
import org.fitness.fitnesstracker.dto.ActivityDto;
import org.fitness.fitnesstracker.services.activity.ActivityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ActivityController {

    private final ActivityService activityService;

    @PostMapping("/activity")
    public ResponseEntity<?> postActivity(@RequestBody ActivityDto activityDto) {
        ActivityDto createActivity = activityService.postActivity(activityDto);

        if(createActivity != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createActivity);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating activity");
        }
    }

    @GetMapping("/activities")
    public ResponseEntity<?> getActivities() {
        try{
            return ResponseEntity.ok(activityService.getActivities());
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}
