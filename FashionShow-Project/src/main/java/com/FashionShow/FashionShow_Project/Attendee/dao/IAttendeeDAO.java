package com.FashionShow.FashionShow_Project.Attendee.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FashionShow.FashionShow_Project.Attendee.modelEntity.Attendee;

public interface IAttendeeDAO extends JpaRepository<Attendee, Long> {
    
}
