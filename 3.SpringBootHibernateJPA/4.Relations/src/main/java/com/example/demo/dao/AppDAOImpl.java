package com.example.demo.dao;

import com.example.demo.entity.Post;
import com.example.demo.entity.ProfilePicture;
import com.example.demo.entity.Tag;
import com.example.demo.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO {
    private EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public User findUserById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @Transactional
    public void deleteUserById(int id) {
        User user = entityManager.find(User.class, id);

        System.out.println("MY USER: " + user);

        List<Post> posts = user.getPosts();

        // break association of all posts for the user
        for (Post post : posts) {
            post.setUser(null);
        }

        entityManager.remove(user);
    }

    @Override
    public ProfilePicture findUserPictureById(int id) {
        return entityManager.find(ProfilePicture.class, id);
    }

    @Override
    @Transactional
    public void deleteProfilePictureById(int id) {
        ProfilePicture profilePicture = entityManager.find(ProfilePicture.class, id);

        // remove the associated object reference, break bi-directional link
        profilePicture.getUser().setProfilePicture(null);

        entityManager.remove(profilePicture);
    }

    @Override
    public List<Post> findPostsByUserId(int id) {
        TypedQuery<Post> query = entityManager.createQuery(
            "from Post where user.id = :data", Post.class
        );
        query.setParameter("data", id);

        return query.getResultList();
    }

    @Override
    public User findUserByIdJoinFetch(int id) {
        TypedQuery<User> query = entityManager.createQuery(
                "select i from User i JOIN FETCH i.posts JOIN FETCH i.profilePicture where i.id = :data", User.class
        );
        query.setParameter("data", id);

        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public Post findPostById(int id) {
        return entityManager.find(Post.class, id);
    }

    @Override
    @Transactional
    public void updatePost(Post post) {
        entityManager.merge(post);
    }

    @Override
    @Transactional
    public void deletePostById(int id) {
        Post post = entityManager.find(Post.class, id);
        entityManager.remove(post);
    }

    @Override
    @Transactional
    public void savePost(Post post) {
        entityManager.persist(post);
    }

    @Override
    public Post findPostAndCommentsByPostId(int id) {
        TypedQuery<Post> query = entityManager.createQuery(
          "select p from Post p JOIN FETCH p.comments where p.id = :data", Post.class
        );
        query.setParameter("data", id);

        return query.getSingleResult();
    }

    @Override
    public Post findPostAndTagsByPostId(int id) {
        TypedQuery<Post> query = entityManager.createQuery(
                "select p from Post p JOIN FETCH p.tags where p.id = :data", Post.class
        );
        query.setParameter("data", id);

        return query.getSingleResult();
    }

    @Override
    public Tag findTagAndPostsByTagId(int id) {
        TypedQuery<Tag> query = entityManager.createQuery(
                "select t from Tag t JOIN FETCH t.posts where t.id = :data", Tag.class
        );
        query.setParameter("data", id);

        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void updateTag(Tag tag) {
        entityManager.merge(tag);
    }

    @Override
    @Transactional
    public void deleteTagById(int id) {
        Tag tag = entityManager.find(Tag.class, id);
        entityManager.remove(tag);
    }
}
