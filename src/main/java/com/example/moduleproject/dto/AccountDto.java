package com.example.moduleproject.dto;

import com.example.moduleproject.domain.Account;
import com.example.moduleproject.domain.constant.UsageType;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public record AccountDto(
        Long idx,
        Long userIdx,
        UsageType usage,
        int cost,
        String momo
) {

    public AccountDto fromEntity(Account account) {
        return new AccountDto(
                account.getIdx(),
                account.getUserIdx(),
                account.getUsage(),
                account.getCost(),
                account.getMomo()
        );
    }
}
