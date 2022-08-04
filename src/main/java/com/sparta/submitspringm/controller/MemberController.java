package com.sparta.submitspringm.controller;

import com.sparta.submitspringm.dto.*;
import com.sparta.submitspringm.models.Comment;
import com.sparta.submitspringm.models.Post;
import com.sparta.submitspringm.repository.CommentRepository;
import com.sparta.submitspringm.repository.PostRepository;
import com.sparta.submitspringm.service.CommentService;
import com.sparta.submitspringm.service.MemberService;
import com.sparta.submitspringm.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class MemberController {
    private final MemberService userService;
    private final CommentRepository commentRepository;
    private final CommentService commentService;
    private final PostRepository postRepository;
    private final PostService postService;


    @GetMapping("/me")
    public ResponseEntity<MemberResponseDto> getMyUserInfo() {
        return ResponseEntity.ok(userService.getMyInfo());
    }

    @GetMapping("/{username}")
    public ResponseEntity<MemberResponseDto> getUserInfo(@PathVariable String username) {
        return ResponseEntity.ok(userService.getUserInfo(username));
    }

    //댓글 작성
    @PostMapping("/comments")
    public Comment createComment(@RequestBody CommentRequestDto requestDto){
        return commentService.saveComment(requestDto);
    }

    //댓글 수정
    @PutMapping("/comments/{commentId}")
    public CommentResponseDto updateComment(@PathVariable Long commentId, @RequestBody CommentRequestDto requestDto){
        return commentService.editComment(commentId, requestDto);
    }

    //댓글 삭제
    @DeleteMapping("/comments/{commentId}")
    public Long deleteComment(@PathVariable Long commentId){
        commentRepository.deleteById(commentId);
        return commentId;
    }

    //게시글 작성
    @PostMapping("/posts")
    public Post createPost(@RequestBody PostRequestDto requestDto){
        return postService.savePost(requestDto);
    }

    //게시글 조회(단일)
    @GetMapping("/posts/{id}")
    public PostResponseDto findById(@PathVariable Long id){
        return postService.findById(id);
    }

    //게시글 수정
    @PutMapping("/posts/{id}")
    public PostResponseDto updatePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto){
        postService.update(id, requestDto);
        return postService.findById(id);
    }

    //게시글 삭제
    @DeleteMapping("/posts/{id}")
    public Long deletePost(@PathVariable Long id){
        postRepository.deleteById(id);
        return id;
    }
}
