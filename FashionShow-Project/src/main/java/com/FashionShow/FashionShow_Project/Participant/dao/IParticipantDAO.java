package com.FashionShow.FashionShow_Project.Participant.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FashionShow.FashionShow_Project.Participant.modelEntity.Participant;

public interface IParticipantDAO extends JpaRepository<Participant, Long> {
    
}
