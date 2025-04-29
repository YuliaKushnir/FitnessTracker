package org.fitness.fitnesstracker.repository;

import org.fitness.fitnesstracker.models.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Long> {

}
