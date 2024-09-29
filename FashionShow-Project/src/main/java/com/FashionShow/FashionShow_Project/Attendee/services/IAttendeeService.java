package com.FashionShow.FashionShow_Project.Attendee.services;

import java.util.List;

import com.FashionShow.FashionShow_Project.Attendee.modelEntity.Attendee;

public interface IAttendeeService {
    public List<Attendee> findAll();

    public Attendee save(Attendee attendee);

    public Attendee findById(Long id);

    public void delete(Long id);
}
