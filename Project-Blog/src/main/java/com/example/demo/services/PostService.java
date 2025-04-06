package com.example.demo.services;

import com.example.demo.domain.CreatePost;
import com.example.demo.domain.UpdatePost;
import com.example.demo.domain.entities.Post;
import com.example.demo.domain.entities.User;

import java.util.List;
import java.util.UUID;

public interface PostService {
    List<Post> getAllPosts(UUID categoryId, UUID tagId);

    List<Post> getDraftPosts(User user);

    Post getPost(UUID id);

    Post createPost(User user, CreatePost createPost);

    Post updatePost(UUID id, UpdatePost updatePost);

    void deletePost(UUID id);
}
