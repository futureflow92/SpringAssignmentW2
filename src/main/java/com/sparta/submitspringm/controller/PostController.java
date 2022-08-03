package com.sparta.submitspringm.controller;

import com.sparta.submitspringm.dto.PostRequestDto;
import com.sparta.submitspringm.dto.PostResponseDto;
import com.sparta.submitspringm.models.Post;
import com.sparta.submitspringm.repository.CommentRepository;
import com.sparta.submitspringm.repository.PostRepository;
import com.sparta.submitspringm.service.PostService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostRepository postRepository;
    private final PostService postService;

    //게시글 작성
    @PostMapping("/api/auth/posts")
    public Post createPost(@RequestBody PostRequestDto requestDto){
        return postService.savePost(requestDto);
    }

    //전체 게시글 조회
    @GetMapping("/api/posts")
    public List<Post> readPost(){
        return postRepository.findAllByOrderByModifiedAtDesc();
    }

    //게시글 조회(단일)
    @GetMapping("/api/posts/{id}")
    public PostResponseDto findById(@PathVariable Long id){
        return postService.findById(id);
    }

    //게시글 수정
    @PutMapping("/api/auth/posts/{id}")
    public PostResponseDto updatePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto){
        postService.update(id, requestDto);
        return postService.findById(id);
    }

    //게시글 삭제
    @DeleteMapping("/api/auth/posts/{id}")
    public Long deletePost(@PathVariable Long id){
        postRepository.deleteById(id);
        return id;
    }

}
