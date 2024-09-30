package com.FashionShow.FashionShow_Project.Media.services;

import java.util.List;

import com.FashionShow.FashionShow_Project.Media.modelEntity.Media;

public interface IMediaService {
    public List<Media> findAll();

    public Media save(Media media);

    public Media findById(Long id);

    public void delete(Long id);
}
