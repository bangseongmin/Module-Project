package com.example.moduleproject.controller;

import com.example.moduleproject.dto.AccountDto;
import com.example.moduleproject.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/members")
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    public void writeHistory(AccountDto request) {
        accountService.writeHistory(request);
    }
}
