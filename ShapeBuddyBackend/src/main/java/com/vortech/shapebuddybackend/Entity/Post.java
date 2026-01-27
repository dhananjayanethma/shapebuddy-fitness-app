package com.vortech.shapebuddybackend.Entity;


import jakarta.persistence.*;

@Table
@Entity(name = "posts")
public class Post {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "user_id")
    private int userId;
    @Column(name = "timestamp")
    private String timestamp;
    @Column(name = "contentDescription")
    private String contentDescription;
    @Column(name = "mediaLink")
    private String mediaLink;
    @Column(name = "mediaType")
    private String mediaType;

    public Post() {
    }

    public Post(int id, int userId, String timestamp, String contentDescription, String mediaLink, String mediaType) {
        this.id = id;
        this.userId = userId;
        this.timestamp = timestamp;
        this.contentDescription = contentDescription;
        this.mediaLink = mediaLink;
        this.mediaType = mediaType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getContentDescription() {
        return contentDescription;
    }

    public void setContentDescription(String contentDescription) {
        this.contentDescription = contentDescription;
    }

    public String getMediaLink() {
        return mediaLink;
    }

    public void setMediaLink(String mediaLink) {
        this.mediaLink = mediaLink;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }
}
