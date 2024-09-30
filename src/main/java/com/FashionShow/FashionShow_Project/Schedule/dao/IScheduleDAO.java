package com.FashionShow.FashionShow_Project.Schedule.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FashionShow.FashionShow_Project.Schedule.modelEntity.Schedule;

public interface IScheduleDAO extends JpaRepository<Schedule, Long> {
    
}
