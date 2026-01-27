package com.vortech.shapebuddybackend.Entity;

import jakarta.persistence.*;

@Table
@Entity(name = "media")
public class Media {
    @Id
    @Column(name = "")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "post_id")
    private int postId;
    @Column(name = "media_type")
    private String mediaType;
    @Column(name = "media_url")
    private String mediaUrl;
    @Column(name = "description")
    private String description;

    public Media() {
    }

    public Media(int id, int postId, String mediaType, String mediaUrl, String description) {
        this.id = id;
        this.postId = postId;
        this.mediaType = mediaType;
        this.mediaUrl = mediaUrl;
        this.description = description;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getMediaUrl() {
        return mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
