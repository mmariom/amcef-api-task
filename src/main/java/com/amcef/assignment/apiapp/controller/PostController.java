package com.amcef.assignment.apiapp.controller;


import com.amcef.assignment.apiapp.dto.PostDTO;
import com.amcef.assignment.apiapp.dto.UpdatePostDTO;
import com.amcef.assignment.apiapp.model.Post;
import com.amcef.assignment.apiapp.service.impl.PostServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostServiceImpl postService;

    public PostController(PostServiceImpl postService) {
        this.postService = postService;
    }


    @PostMapping
    public ResponseEntity<Post> createPost(@Valid @RequestBody PostDTO postDTO) {

        return new ResponseEntity<>(postService.createPost(postDTO), HttpStatus.CREATED);
    }



    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        return new ResponseEntity<>(postService.getAllPosts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Integer id) {
        return new ResponseEntity<>(postService.getPostById(id), HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Post>> getPostsByUserId(@PathVariable Integer userId) {
        return new ResponseEntity<>(postService.getPostsByUserId(userId), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Integer id) {
        postService.deletePost(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Integer id, @Valid @RequestBody UpdatePostDTO updatedPost) {
        return new ResponseEntity<>(postService.updatePost(id, updatedPost), HttpStatus.OK);
    }
}
