package com.FashionShow.FashionShow_Project.Attendee.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FashionShow.FashionShow_Project.Attendee.dao.IAttendeeDAO;
import com.FashionShow.FashionShow_Project.Attendee.modelEntity.Attendee;

@Service
public class AttendeeService implements IAttendeeService {
    @Autowired
    private IAttendeeDAO attendeeDAO;

    @Override
    public List<Attendee> findAll() {
        return attendeeDAO.findAll();
    }

    @Override
    public Attendee save(Attendee attendee) {
        return attendeeDAO.save(attendee);
    }

    @Override
    public Attendee findById(Long id) {
        return attendeeDAO.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        attendeeDAO.deleteById(id);
    }

}