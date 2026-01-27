package com.vortech.shapebuddybackend.Controllers;

import com.vortech.shapebuddybackend.Entity.Post;
import com.vortech.shapebuddybackend.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public ResponseEntity<List<Post>> getPosts() {
        List<Post> posts = postService.findAll();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Post>> getPostByUserId(@PathVariable int userId) {
        List<Post> posts = postService.findByUserId(userId);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        Post Savepost = postService.save(post);
        return new ResponseEntity<>(Savepost, HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deletePost(@PathVariable int userId) {
        this.postService.deleteById(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{postId}")
    public ResponseEntity<Post> updatePost(@PathVariable int postId, @RequestBody Post updatedPost) {
        Optional<Post> optionalPost = postService.findById(postId);
        if(optionalPost.isPresent()){
            Post existingPost = optionalPost.get();
            if(updatedPost.getMediaLink() !=null){
                existingPost.setMediaLink(updatedPost.getMediaLink());
            }
            if(updatedPost.getMediaType()!=null){
                existingPost.setMediaType(updatedPost.getMediaType());
            }
            if(updatedPost.getContentDescription()!=null){
                existingPost.setContentDescription(updatedPost.getContentDescription());
            }

            Post savedPost = postService.save(existingPost);
            return new ResponseEntity<>(savedPost, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
