package com.FashionShow.FashionShow_Project.Media.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FashionShow.FashionShow_Project.Media.dao.IMediaDAO;
import com.FashionShow.FashionShow_Project.Media.modelEntity.Media;

@Service
public class MediaService implements IMediaService {
    @Autowired
    private IMediaDAO mediaDAO;

    @Override
    public List<Media> findAll() {
        return mediaDAO.findAll();
    }

    @Override
    public Media save(Media media) {
        return mediaDAO.save(media);
    }

    @Override
    public Media findById(Long id) {
        return mediaDAO.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        mediaDAO.deleteById(id);
    }
}
