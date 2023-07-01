package com.amcef.assignment.apiapp.service.impl;

import com.amcef.assignment.apiapp.client.PostClient;
import com.amcef.assignment.apiapp.client.UserClient;
import com.amcef.assignment.apiapp.dto.PostDTO;
import com.amcef.assignment.apiapp.dto.UpdatePostDTO;
import com.amcef.assignment.apiapp.dto.UserDTO;
import com.amcef.assignment.apiapp.exception.PostNotFoundException;
import com.amcef.assignment.apiapp.exception.UserNotFoundException;
import com.amcef.assignment.apiapp.model.Post;
import com.amcef.assignment.apiapp.repo.PostRepository;
import com.amcef.assignment.apiapp.service.PostService;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final UserClient userClient;
    private final PostClient postClient;


    public PostServiceImpl(PostRepository postRepository, UserClient userClient, PostClient postClient) {
        this.postRepository = postRepository;
        this.userClient = userClient;
        this.postClient = postClient;
    }
    @Override
    public Post createPost(PostDTO postDTO) {
        try {
            UserDTO userDTO = userClient.getUser(postDTO.getUserId());
            log.info("UserDTO: " + userDTO);

            if (userDTO != null) {
                Post post = new Post();

                post.setUserId(postDTO.getUserId());
                post.setTitle(postDTO.getTitle());
                post.setBody(postDTO.getBody());

                return postRepository.save(post);
            } else {
                throw new UserNotFoundException("User with id " + postDTO.getUserId() + " not found.");
            }
        } catch (FeignException.NotFound ex) {
            throw new UserNotFoundException("User with id " + postDTO.getUserId() + " not found.");
        }
    }


//    public Post getPostById(Integer id) {
//        return postRepository.findById(id).orElseThrow(() -> new PostNotFoundException("Post with id " + id + " not found."));
//    }
    @Override
    public Post getPostById(Integer id) {
        Optional<Post> postOptional = postRepository.findById(id);

        if(postOptional.isPresent()) {
            return postOptional.get();
        } else {
            PostDTO postDTO = postClient.getPost(id);
            if (postDTO == null) {
                throw new PostNotFoundException("Post with id " + id + " not found in the system or external API.");
            }
            Post post = new Post();
//            post.setId(id);
//            log.info("id: " + id);
            post.setTitle(postDTO.getTitle());
            post.setBody(postDTO.getBody());
            post.setUserId(postDTO.getUserId());
            postRepository.save(post);
            return post;
        }
    }


    @Override
    public List<Post> getPostsByUserId(Integer userId) {
        List<Post> posts = postRepository.findByUserId(userId);
        if (posts.isEmpty()) {
            throw new PostNotFoundException("No posts found for user with id " + userId + ".");
        }
        return posts;
    }


    @Override
    public List<Post> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        if (posts.isEmpty()) {
            throw new PostNotFoundException("No posts found.");
        }
        return posts;
    }


    @Override
    public void deletePost(Integer id) {
        if(!postRepository.existsById(id)) {
            throw new PostNotFoundException("Post with id " + id + " does not exist.");
        }
        postRepository.deleteById(id);
    }

    @Override
    public Post updatePost(Integer id, UpdatePostDTO updatedPost) {
        Post existingPost = postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException("Post with id " + id + " does not exist."));

        existingPost.setTitle(updatedPost.getTitle());
        existingPost.setBody(updatedPost.getBody());

        return postRepository.save(existingPost);
    }


}
