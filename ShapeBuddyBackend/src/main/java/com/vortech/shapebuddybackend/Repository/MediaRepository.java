package com.vortech.shapebuddybackend.Repository;

import com.vortech.shapebuddybackend.Entity.Media;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MediaRepository extends JpaRepository<Media, Integer> {

    public List<Media> findByPostId(int postId);

    public void deleteById(int mediaId);
}
