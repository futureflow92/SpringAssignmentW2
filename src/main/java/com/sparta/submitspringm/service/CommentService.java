package com.sparta.submitspringm.service;

import com.sparta.submitspringm.dto.CommentRequestDto;
import com.sparta.submitspringm.dto.CommentResponseDto;
import com.sparta.submitspringm.models.Comment;
import com.sparta.submitspringm.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;

    //댓글 작성
    @Transactional
    public Comment saveComment(CommentRequestDto requestDto) {
        Comment comment = new Comment(requestDto);
        return commentRepository.save(comment);
    }

    //댓글 수정
    @Transactional
    public CommentResponseDto editComment(Long id, CommentRequestDto requestDto){
        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("댓글이 존재하지 않습니다.")
        );
        comment.updateComment(requestDto);
        return new CommentResponseDto(comment);
    }
}
