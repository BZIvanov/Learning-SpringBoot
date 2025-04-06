package com.example.demo.domain.dtos;

import com.example.demo.domain.PostStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostDto {
    private UUID id;

    private String title;

    private String content;

    private AuthorDto author;

    private CategoryDto category;

    private Set<TagDto> tags;

    private Integer readingTime;

    private PostStatus status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
