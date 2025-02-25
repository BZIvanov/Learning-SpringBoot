package com.example.demo.dao;

import com.example.demo.entity.Post;
import com.example.demo.entity.ProfilePicture;
import com.example.demo.entity.Tag;
import com.example.demo.entity.User;

import java.util.List;

public interface AppDAO {
    void save(User user);

    User findUserById(int id);

    void deleteUserById(int id);

    ProfilePicture findUserPictureById(int id);

    void deleteProfilePictureById(int id);

    List<Post> findPostsByUserId(int id);

    User findUserByIdJoinFetch(int id);

    void updateUser(User user);

    Post findPostById(int id);

    void updatePost(Post post);

    void deletePostById(int id);

    void savePost(Post post);

    Post findPostAndCommentsByPostId(int id);

    Post findPostAndTagsByPostId(int id);

    Tag findTagAndPostsByTagId(int id);

    void updateTag(Tag tag);

    void deleteTagById(int id);
}
