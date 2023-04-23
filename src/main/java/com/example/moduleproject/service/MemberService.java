package com.example.moduleproject.service;

import com.example.moduleproject.domain.Member;
import com.example.moduleproject.dto.MemberDto;
import com.example.moduleproject.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final AccountService accountService;


    /**
     * 회원가입
     *
     * @param request
     */
    public MemberDto registerMember(MemberDto request) {
        /**
         * 로직
         *
         * 1. 중복 조회
         * 2. 유효성 체크
         *   - 아이디 길이
         *   - 비밀번호
         * 3. 멤버 등록
         *   - 비밀번호 암호화
         */

        Optional<Member> user = memberRepository.findByUsername(request.username());

        if(!Objects.isNull(user)) {
            // 중복 에러
            return null;
        }

        // TODO: 비밀번호 암호화
        Member member = memberRepository.save(Member.builder()
                .username(request.username())
                .password(request.password())
                .fullname(request.fullname())
                .birthday(request.birthday())
                .age(request.age())
                .build());

        accountService.createAccount(member);

        return MemberDto.fromEntity(member);
    }

    /**
     * 로그인
     * @param request
     */
    public String login(MemberDto request) {
        /**
         * 1. 멤버 찾기(아이디와 비밀번호를 사용)
         * 2. 존재할 경우 토큰 발급
         */
        Optional<Member> user = memberRepository.findByUsernameAndPassword(request.username(), request.password());

        if(Objects.isNull(user)) {
            // 존재하지 않은 회원인 경우 에러 발생
            return null;
        }

        // 토큰 발급
        return "TOKEN";
    }

    public Member findByIdOrException(Long memberId) {
        return memberRepository.findById(memberId).orElseThrow(() -> {
            throw new NullPointerException();
        });
    }
}
