package org.fitness.fitnesstracker.services.stats;

import org.fitness.fitnesstracker.dto.GraphDto;
import org.fitness.fitnesstracker.dto.StatsDto;

public interface StatsService {

    StatsDto getStats();

    GraphDto getGraphStats();

}
