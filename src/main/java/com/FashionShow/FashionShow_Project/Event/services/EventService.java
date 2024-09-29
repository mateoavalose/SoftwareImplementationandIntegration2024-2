package com.FashionShow.FashionShow_Project.Event.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FashionShow.FashionShow_Project.Event.dao.IEventDAO;
import com.FashionShow.FashionShow_Project.Event.modelEntity.Event;

@Service
public class EventService implements IEventService {
    @Autowired
    private IEventDAO eventDAO;

    @Override
    public List<Event> findAll() {
        return eventDAO.findAll();
    }

    @Override
    public Event save(Event event) {
        return eventDAO.save(event);
    }

    @Override
    public Event findById(Long id) {
        return eventDAO.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        eventDAO.deleteById(id);
    }
}
