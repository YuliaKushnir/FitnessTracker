package org.fitness.fitnesstracker.controllers;

import lombok.RequiredArgsConstructor;
import org.fitness.fitnesstracker.dto.GraphDto;
import org.fitness.fitnesstracker.services.stats.StatsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("*")
public class StatsController {

    private final StatsService statsService;

    @GetMapping("/stats")
    public ResponseEntity<?> getStats(){
        return ResponseEntity.ok(statsService.getStats());
    }

    @GetMapping("/graphs")
    public ResponseEntity<?> getGraphStats(){
        GraphDto graphDto = statsService.getGraphStats();

        if(graphDto != null){
            return ResponseEntity.ok(graphDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
