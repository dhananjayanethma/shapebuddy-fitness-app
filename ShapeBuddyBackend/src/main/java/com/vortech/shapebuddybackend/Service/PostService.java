package com.vortech.shapebuddybackend.Service;

import com.vortech.shapebuddybackend.Entity.Post;
import com.vortech.shapebuddybackend.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> findAll() {
        return this.postRepository.findAll();
    }

    public List<Post> findByUserId(int userId) {
        return this.findByUserId(userId);
    }

    public Post save(Post post) {
        return  this.postRepository.save(post);
    }

    public void deleteById(int userId) {
        this.postRepository.deleteById(userId);
    }

    public Optional<Post> findById(int postId) {
        return this.postRepository.findById(postId);
    }
}
