package com.example.moduleproject.controller;

import com.example.moduleproject.dto.MemberDto;
import com.example.moduleproject.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    /**
     * 회원가입
     */
    @PostMapping
    public void registerMember(MemberDto request) {
        MemberDto member = memberService.registerMember(request);
    }

    /**
     * 로그인
     */
    @PostMapping("/login")
    public void loginMember(MemberDto request) {
        memberService.login(request);
    }
}
