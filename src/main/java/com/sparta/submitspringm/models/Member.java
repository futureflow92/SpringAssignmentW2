package com.sparta.submitspringm.models;

import com.sparta.submitspringm.Authority;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Pattern(regexp="^[a-zA-Z0-9]{3,12}$", message="아이디를 3~12자로 입력해주세요.(특수문자x)")
    @Column(nullable = false, unique = true)
    private String username;

//    @Pattern(regexp="^[a-zA-Z0-9]{4,12}$", message="비밀번호를 4~12자로 입력해주세요.(특수문자x)")
    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Authority authority;

    @Builder
    public Member(String username, String password, Authority authority) {
        this.username = username;
        this.password = password;
        this.authority = authority;
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