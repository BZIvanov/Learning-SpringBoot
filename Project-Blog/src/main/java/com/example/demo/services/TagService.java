package com.example.demo.services;

import com.example.demo.domain.entities.Tag;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface TagService {
    List<Tag> getTags();

    Tag getTagByID(UUID id);

    List<Tag> getTagByIds(Set<UUID> ids);

    List<Tag> createTags(Set<String> tagNames);

    void deleteTag(UUID id);
}
