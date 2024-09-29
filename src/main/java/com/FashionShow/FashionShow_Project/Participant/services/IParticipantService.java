package com.FashionShow.FashionShow_Project.Participant.services;

import java.util.List;

import com.FashionShow.FashionShow_Project.Participant.modelEntity.Participant;

public interface IParticipantService {
    public List<Participant> findAll();

    public Participant save(Participant participant);

    public Participant findById(Long id);

    public void delete(Long id);
}
