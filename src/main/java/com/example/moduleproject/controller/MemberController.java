package com.example.moduleproject.controller;

import com.example.moduleproject.dto.MemberDto;
import com.example.moduleproject.service.AccountService;
import com.example.moduleproject.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;
    private final AccountService accountService;

    /**
     * 회원가입
     */
    @PostMapping
    public void registerMember(MemberDto request) {
        MemberDto member = memberService.registerMember(request);

        accountService.createAccount(member);
    }

    /**
     * 로그인
     */
    @PostMapping("/login")
    public void loginMember(MemberDto request) {
        memberService.login(request);
    }
}
