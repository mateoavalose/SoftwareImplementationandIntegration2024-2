package com.FashionShow.FashionShow_Project.Event.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FashionShow.FashionShow_Project.Event.modelEntity.Event;

public interface IEventDAO extends JpaRepository<Event, Long> {
    
}
