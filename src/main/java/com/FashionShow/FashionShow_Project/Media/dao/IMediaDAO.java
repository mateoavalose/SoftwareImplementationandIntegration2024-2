package com.FashionShow.FashionShow_Project.Media.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FashionShow.FashionShow_Project.Media.modelEntity.Media;

public interface IMediaDAO extends JpaRepository<Media, Long> {
    
}
