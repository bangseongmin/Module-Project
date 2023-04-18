package com.example.moduleproject.dto;

import com.example.moduleproject.domain.Member;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

public record MemberDto(
        Long idx,
        String username,
        String password,
        String fullname,
        int age,
        LocalDate birthday
) {

    public static MemberDto fromEntity(Member member) {
        return new MemberDto(
                member.getIdx(),
                member.getUsername(),
                member.getPassword(),
                member.getFullname(),
                member.getAge(),
                member.getBirthday()
        );
    }
}
