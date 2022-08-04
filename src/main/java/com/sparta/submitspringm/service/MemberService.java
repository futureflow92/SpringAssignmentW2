package com.sparta.submitspringm.service;

import com.sparta.submitspringm.dto.MemberResponseDto;
import com.sparta.submitspringm.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import com.sparta.submitspringm.security.SecurityUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository userRepository;

    @Transactional(readOnly = true)
    public MemberResponseDto getUserInfo(String username) {
        return userRepository.findByUsername(username)
                .map(MemberResponseDto::of)
                .orElseThrow(() -> new RuntimeException("유저 정보가 없습니다."));
    }

    // 현재 SecurityContext 에 있는 유저 정보 가져오기
    @Transactional(readOnly = true)
    public MemberResponseDto getMyInfo() {
        return userRepository.findById(SecurityUtil.getCurrentMemberId())
                .map(MemberResponseDto::of)
                .orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다."));
    }
}
