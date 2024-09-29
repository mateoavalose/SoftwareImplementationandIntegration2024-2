package com.FashionShow.FashionShow_Project.Participant.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FashionShow.FashionShow_Project.Participant.dao.IParticipantDAO;
import com.FashionShow.FashionShow_Project.Participant.modelEntity.Participant;

@Service
public class ParticipantService implements IParticipantService {
    @Autowired
    private IParticipantDAO participantDAO;

    @Override
    public List<Participant> findAll() {
        return participantDAO.findAll();
    }

    @Override
    public Participant save(Participant participant) {
        return participantDAO.save(participant);
    }

    @Override
    public Participant findById(Long id) {
        return participantDAO.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        participantDAO.deleteById(id);
    }

}