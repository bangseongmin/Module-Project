package com.example.moduleproject.controller;

import com.example.moduleproject.dto.AccountDto;
import com.example.moduleproject.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    public void writeHistory(AccountDto request) {
        accountService.writeHistory(request);
    }

    @DeleteMapping("/{idx}")
    public void deleteHistory(@PathVariable Long idx) {
        accountService.deleteHistory(idx);
    }
}
