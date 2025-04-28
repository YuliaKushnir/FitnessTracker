package org.fitness.fitnesstracker.services.activity;

import lombok.RequiredArgsConstructor;
import org.fitness.fitnesstracker.dto.ActivityDto;
import org.fitness.fitnesstracker.models.Activity;
import org.fitness.fitnesstracker.repository.ActivityRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActivityServiceImpl implements ActivityService{
    private final ActivityRepository activityRepository;

    public ActivityDto postActivity(ActivityDto activityDto) {
        Activity activity = new Activity();

        activity.setSteps(activityDto.getSteps());
        activity.setDate(activityDto.getDate());
        activity.setDistance(activityDto.getDistance());
        activity.setCaloriesBurned(activityDto.getCaloriesBurned());

        return activityRepository.save(activity).getActivityDto();

    }

    public List<ActivityDto> getActivities() {
        List<Activity> activities = activityRepository.findAll();

        return activities.stream().map(Activity::getActivityDto).collect(Collectors.toList());


    }

}
