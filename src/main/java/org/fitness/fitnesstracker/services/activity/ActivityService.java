package org.fitness.fitnesstracker.services.activity;

import org.fitness.fitnesstracker.dto.ActivityDto;

import java.util.List;

public interface ActivityService {
    ActivityDto postActivity(ActivityDto activityDto);

    List<ActivityDto> getActivities();
}
