package com.sparta.submitspringm.controller;

import com.sparta.submitspringm.dto.CommentRequestDto;
import com.sparta.submitspringm.dto.CommentResponseDto;
import com.sparta.submitspringm.models.Comment;
import com.sparta.submitspringm.repository.CommentRepository;
import com.sparta.submitspringm.repository.PostRepository;
import com.sparta.submitspringm.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentRepository commentRepository;

    private final CommentService commentService;

    //댓글 작성
    @PostMapping("/api/auth/comments")
    public Comment createComment(@RequestBody CommentRequestDto requestDto){
        return commentService.saveComment(requestDto);
    }

    //댓글 전체 조회
    @GetMapping("/api/comments")
    public List<Comment> readComment() {
        return commentRepository.findAllByOrderByModifiedAtDesc();
    }

    //댓글 수정
    @PutMapping("/api/auth/comments/{commentId}")
    public CommentResponseDto updateComment(@PathVariable Long commentId, @RequestBody CommentRequestDto requestDto){
        return commentService.editComment(commentId, requestDto);
    }

    //댓글 삭제
    @DeleteMapping("/api/auth/comments/{commentId}")
    public Long deleteComment(@PathVariable Long commentId){
        commentRepository.deleteById(commentId);
        return commentId;
    }
}
