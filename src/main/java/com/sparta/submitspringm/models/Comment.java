package com.sparta.submitspringm.models;

import com.sparta.submitspringm.dto.CommentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Comment extends Timestamped{
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String content;

    public Comment(CommentRequestDto requestDto){
        this.content = requestDto.getContent();
    }

    public void updateComment(CommentRequestDto requestDto){
        this.content = requestDto.getContent();
    }

}
