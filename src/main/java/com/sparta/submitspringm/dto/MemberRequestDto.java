package com.sparta.submitspringm.dto;

import com.sparta.submitspringm.Authority;
import com.sparta.submitspringm.models.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

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

