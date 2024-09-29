package com.FashionShow.FashionShow_Project.Event.services;

import java.util.List;

import com.FashionShow.FashionShow_Project.Event.modelEntity.Event;

public interface IEventService {
    public List<Event> findAll();

    public Event save(Event event);

    public Event findById(Long id);

    public void delete(Long id);
}
