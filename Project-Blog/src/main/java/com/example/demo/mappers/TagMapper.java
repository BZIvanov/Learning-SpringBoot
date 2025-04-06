package com.example.demo.mappers;

import com.example.demo.domain.PostStatus;
import com.example.demo.domain.dtos.TagDto;
import com.example.demo.domain.entities.Post;
import com.example.demo.domain.entities.Tag;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.util.Set;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TagMapper {
    @Mapping(target = "postCount", source = "posts", qualifiedByName = "calculatePostsCount")
    TagDto toTagResponse(Tag tag);

    @Named("calculatePostsCount")
    default Integer calculatePostsCount(Set<Post> posts) {
        if (posts == null) {
            return 0;
        }

        return (int) posts.stream()
                .filter(post -> PostStatus.PUBLISHED.equals(post.getStatus()))
                .count();
    }
}
