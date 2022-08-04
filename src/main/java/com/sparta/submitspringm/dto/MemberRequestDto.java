package com.sparta.submitspringm.dto;

import com.sparta.submitspringm.Authority;
import com.sparta.submitspringm.models.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
//import java.util.regex.Pattern;
//import org.intellij.lang.annotations.Pattern;
//import javax.validation.constraints.NotBlank;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberRequestDto {

    private String username;
    private String password;

    public Member toUser(PasswordEncoder passwordEncoder) {
        return Member.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .authority(Authority.ROLE_USER)
                .build();
    }

    public UsernamePasswordAuthenticationToken toAuthentication() {
        return new UsernamePasswordAuthenticationToken(username, password);
    }
}

//    @NotBlank(message = "아이디를 입력해주세요")
//    @Pattern(regexp="^[a-zA-Z0-9]{3,12}$", message="아이디를 3~12자로 입력해주세요.(특수문자x)")
//    private String username;
//
//    @Pattern(regexp="^[a-zA-Z0-9]{4,12}$", message="비밀번호를 4~12자로 입력해주세요.(특수문자x)")
//    @NotBlank(message = "비밀번호를 입력해주세요")
//    private String password;
//
//    @NotBlank(message = "비밀번호 확인을 입력해주세요")
//    private String checkpw;
