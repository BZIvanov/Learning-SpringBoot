package com.example.demo.controllers;

import com.example.demo.domain.CreatePost;
import com.example.demo.domain.UpdatePost;
import com.example.demo.domain.dtos.CreatePostRequest;
import com.example.demo.domain.dtos.PostDto;
import com.example.demo.domain.dtos.UpdatePostRequest;
import com.example.demo.domain.entities.Post;
import com.example.demo.domain.entities.User;
import com.example.demo.mappers.PostMapper;
import com.example.demo.services.PostService;
import com.example.demo.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    private final PostMapper postMapper;

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<PostDto>> getAllPosts(
            @RequestParam(required = false) UUID categoryId,
            @RequestParam(required = false) UUID tagId
    ) {
        List<Post> posts = postService.getAllPosts(categoryId, tagId);
        List<PostDto> postDtos = posts.stream().map(postMapper::toDto).toList();
        return ResponseEntity.ok(postDtos);
    }

    @GetMapping(path = "/drafts")
    public ResponseEntity<List<PostDto>> getDraftPosts(@RequestAttribute UUID userId) {
        User currentUser = userService.getUserById(userId);
        List<Post> draftPosts = postService.getDraftPosts(currentUser);
        List<PostDto> postDtos = draftPosts.stream().map(postMapper::toDto).toList();
        return ResponseEntity.ok(postDtos);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<PostDto> getPost(@PathVariable UUID id) {
        Post post = postService.getPost(id);
        PostDto postDto = postMapper.toDto(post);
        return ResponseEntity.ok(postDto);
    }

    @PostMapping
    public ResponseEntity<PostDto> createPost(
            @Valid @RequestBody CreatePostRequest createPostRequest,
            @RequestAttribute UUID userId
    ) {
        User currentUser = userService.getUserById(userId);
        CreatePost createPost = postMapper.toCreatePost(createPostRequest);
        Post createdPost = postService.createPost(currentUser, createPost);
        PostDto createdPostDto = postMapper.toDto(createdPost);
        return new ResponseEntity<>(createdPostDto, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<PostDto> updatePost(
            @PathVariable UUID id,
            @Valid @RequestBody UpdatePostRequest updatePostRequest
    ) {
        UpdatePost updatePost = postMapper.toUpdatePost(updatePostRequest);
        Post updatedPost = postService.updatePost(id, updatePost);
        PostDto updatedPostDto = postMapper.toDto(updatedPost);
        return ResponseEntity.ok(updatedPostDto);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable UUID id) {
        postService.deletePost(id);
        return ResponseEntity.noContent().build();
    }
}
