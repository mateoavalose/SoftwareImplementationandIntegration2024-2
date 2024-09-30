package com.FashionShow.FashionShow_Project.Schedule.services;

import java.util.List;

import com.FashionShow.FashionShow_Project.Schedule.modelEntity.Schedule;

public interface IScheduleService {
    public List<Schedule> findAll();

    public Schedule save(Schedule schedule);

    public Schedule findById(Long id);

    public void delete(Long id);
}
