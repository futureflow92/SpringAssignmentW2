package com.sparta.submitspringm.service;

import com.sparta.submitspringm.dto.PostRequestDto;
import com.sparta.submitspringm.dto.PostResponseDto;
import com.sparta.submitspringm.models.Post;
import com.sparta.submitspringm.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    //게시글 작성
    @Transactional
    public Post savePost(PostRequestDto requestDto) {
        Post post = new Post(requestDto);
        return postRepository.save(post);
    }

    //게시글 조회(단일)
    @Transactional
    public PostResponseDto findById(Long id) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        return new PostResponseDto(post);
    }

    //게시글 수정
    @Transactional
    public PostResponseDto update(Long id, PostRequestDto requestDto){
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        post.update(requestDto);
        return new PostResponseDto(post);
    }
}
