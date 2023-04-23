package com.example.moduleproject.service;

import com.example.moduleproject.domain.Member;
import com.example.moduleproject.dto.MemberDto;
import com.example.moduleproject.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.*;

@DisplayName("비즈니스 - 회원")
@ExtendWith({MockitoExtension.class, SpringExtension.class})
class MemberServiceTest {

    private final MemberService memberService;

    @Mock private MemberRepository memberRepository;

    MemberServiceTest(@Autowired MemberService memberService) {
        this.memberService = memberService;
    }

    @DisplayName("중복되지 않은 유저정보를 입력하면, 회원가입이 성공한다.")
    @Test
    void givenUserInfo_whenRequestingSignUp_thenReturnUser() {
        // Given
        willDoNothing().given(memberRepository).findByUsername(anyString());
        willReturn(member()).given(memberRepository).save(any(Member.class));

        // When
        memberService.registerMember(memberDto());

        // Then
        verify(memberRepository, times(1)).findByUsername(anyString());
        verify(memberRepository, times(1)).save(any(Member.class));
    }

    @DisplayName("회원가입한 유저정보를 입력하면, 로그인 성공한다.")
    @Test
    void givenUserInfo_whenRequestingLogin_thenReturnString() {
        // Given
        willReturn(member()).given(memberRepository).findByUsernameAndPassword(anyString(), anyString());

        // When
        memberService.login(memberDto());

        // Then
        verify(memberRepository, times(1)).findByUsernameAndPassword(anyString(), anyString());
    }

    private Member member() {
        return Member.builder()
                .idx(1L)
                .username("artist")
                .password("pw")
                .birthday(LocalDate.of(2023, 3, 1))
                .age(23)
                .fullname("artist")
                .build();
    }

    private MemberDto memberDto() {
        return MemberDto.fromEntity(member());
    }
}