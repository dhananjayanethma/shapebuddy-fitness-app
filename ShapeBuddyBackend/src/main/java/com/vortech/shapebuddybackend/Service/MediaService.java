package com.vortech.shapebuddybackend.Service;

import com.vortech.shapebuddybackend.Entity.Media;
import com.vortech.shapebuddybackend.Repository.MediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MediaService {

    private MediaRepository mediaRepository;

    @Autowired
    public MediaService(MediaRepository mediaRepository) {
        this.mediaRepository = mediaRepository;
    }

    public List<Media> findByPostId(int postId) {
        return this.mediaRepository.findByPostId(postId);
    }

    public Media save(Media media) {
        return this.mediaRepository.save(media);
    }

    public void delete(int mediaId) {
        this.mediaRepository.deleteById(mediaId);
    }
}
