package com.FashionShow.FashionShow_Project.Schedule.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FashionShow.FashionShow_Project.Schedule.dao.IScheduleDAO;
import com.FashionShow.FashionShow_Project.Schedule.modelEntity.Schedule;

@Service
public class ScheduleService implements IScheduleService{
    @Autowired
    private IScheduleDAO scheduleDAO;

    @Override
    public List<Schedule> findAll() {
        return scheduleDAO.findAll();
    }

    @Override
    public Schedule save(Schedule schedule) {
        return scheduleDAO.save(schedule);
    }

    @Override
    public Schedule findById(Long id) {
        return scheduleDAO.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        scheduleDAO.deleteById(id);
    }
}
