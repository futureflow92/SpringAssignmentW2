package com.sparta.submitspringm.controller;

import com.sparta.submitspringm.dto.TokenDto;
import com.sparta.submitspringm.dto.TokenRequestDto;
import com.sparta.submitspringm.dto.MemberRequestDto;
import com.sparta.submitspringm.dto.MemberResponseDto;
import com.sparta.submitspringm.models.Comment;
import com.sparta.submitspringm.models.Post;
import com.sparta.submitspringm.repository.CommentRepository;
import com.sparta.submitspringm.repository.PostRepository;
import com.sparta.submitspringm.service.AuthService;
import com.sparta.submitspringm.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    //회원가입
    @PostMapping("/signup")
    public ResponseEntity<MemberResponseDto> signup(@RequestBody MemberRequestDto memberRequestDto) {
        return ResponseEntity.ok(authService.signup(memberRequestDto));
    }
    //로그인
    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody MemberRequestDto memberRequestDto) {
        return ResponseEntity.ok(authService.login(memberRequestDto));
    }

    @PostMapping("/reissue")
    public ResponseEntity<TokenDto> reissue(@RequestBody TokenRequestDto tokenRequestDto) {
        return ResponseEntity.ok(authService.reissue(tokenRequestDto));
    }

    //댓글 전체 조회
    @GetMapping("/comments")
    public List<Comment> readComment() {
        return commentRepository.findAllByOrderByModifiedAtDesc();
    }

    //전체 게시글 조회
    @GetMapping("/posts")
    public List<Post> readPost(){
        return postRepository.findAllByOrderByModifiedAtDesc();
    }
}
