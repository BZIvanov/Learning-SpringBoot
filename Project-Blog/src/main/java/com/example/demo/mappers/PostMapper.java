package com.example.demo.mappers;

import com.example.demo.domain.CreatePost;
import com.example.demo.domain.UpdatePost;
import com.example.demo.domain.dtos.CreatePostRequest;
import com.example.demo.domain.dtos.PostDto;
import com.example.demo.domain.dtos.UpdatePostRequest;
import com.example.demo.domain.entities.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PostMapper {
    @Mapping(target = "author", source = "author")
    @Mapping(target = "category", source = "category")
    @Mapping(target = "tags", source = "tags")
    @Mapping(target = "status", source = "status")
    PostDto toDto(Post post);

    CreatePost toCreatePost(CreatePostRequest createPostRequest);

    UpdatePost toUpdatePost(UpdatePostRequest updatePostRequest);
}
