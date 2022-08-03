package com.sparta.submitspringm.dto;

import com.sparta.submitspringm.models.Post;
import com.sparta.submitspringm.models.Timestamped;
import lombok.Getter;
import org.springframework.data.annotation.LastModifiedBy;

import java.time.LocalDateTime;

@Getter
public class PostResponseDto extends Timestamped {

    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public PostResponseDto(Post post){
        this.createdAt = post.getCreatedAt();
        this.modifiedAt = post.getModifiedAt();
        this.title = post.getTitle();
        this.content = post.getContent();
    }
}
