package com.sparta.submitspringm.dto;

import com.sparta.submitspringm.models.Comment;
import com.sparta.submitspringm.models.Timestamped;
import lombok.Getter;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
public class CommentResponseDto extends Timestamped {
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public CommentResponseDto(Comment comment){
        this.createdAt = comment.getCreatedAt();
        this.modifiedAt = comment.getModifiedAt();
        this.content = comment.getContent();
    }
}
