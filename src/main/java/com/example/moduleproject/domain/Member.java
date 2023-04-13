package com.example.moduleproject.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@Entity
public class Member {

    /**
     * 인덱스
     */
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    /**
     * 유저 아이디
     */
    @Column(name = "username", nullable = false)
    private String username;

    /**
     * 유저 패스워드
     */
    @Column(name = "password", nullable = false)
    private String password;

    /**
     * 유저 이름
     */
    @Column(name = "fullname", nullable = false)
    private String fullname;

    /**
     * 나이
     */
    @Column(name = "age")
    private int age;

    /**
     * 생일
     */
    @Column(name = "birthday")
    private LocalDate birthday;

    @Builder
    public Member(String username, String password, String fullname, int age, LocalDate birthday) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.age = age;
        this.birthday = birthday;
    }
}
