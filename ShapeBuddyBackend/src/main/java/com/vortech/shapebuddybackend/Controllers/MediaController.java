package com.vortech.shapebuddybackend.Controllers;

import com.vortech.shapebuddybackend.Entity.Media;
import com.vortech.shapebuddybackend.Service.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/media")
public class MediaController {

    @Autowired
    private MediaService mediaService;

    @GetMapping("/{postId}")
    public ResponseEntity<List<Media>> getMediaByPostId(@PathVariable int postId) {
        List<Media> mediaList = mediaService.findByPostId(postId);
        return new ResponseEntity<>(mediaList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Media> createMedia(@RequestBody Media media) {
        Media savedMedia = mediaService.save(media);
        return new ResponseEntity<>(savedMedia, HttpStatus.CREATED);
    }

    @DeleteMapping("/{mediaId}")
    public ResponseEntity<Media> deleteMedia(@PathVariable int mediaId) {
        mediaService.delete(mediaId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
