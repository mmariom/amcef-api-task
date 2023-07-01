package com.amcef.assignment.apiapp.service;

import com.amcef.assignment.apiapp.dto.PostDTO;
import com.amcef.assignment.apiapp.dto.UpdatePostDTO;
import com.amcef.assignment.apiapp.model.Post;

import java.util.List;

public interface PostService {

    Post createPost(PostDTO postDTO);

    Post getPostById(Integer id);

    List<Post> getPostsByUserId(Integer userId);

    List<Post> getAllPosts();


    void deletePost(Integer id);


    Post updatePost(Integer id, UpdatePostDTO updatedPost);


}
