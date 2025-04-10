package com.example.demo.repositories;

import com.example.demo.domain.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface TagRepository extends JpaRepository<Tag, UUID> {
    @Query("SELECT t FROM Tag t LEFT JOIN FETCH t.posts")
    List<Tag> findAllWithPostCount();

    List<Tag> findByNameIn(Set<String> names);
}
