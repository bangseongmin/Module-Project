package com.example.moduleproject.dto;

import com.example.moduleproject.domain.Account;
import com.example.moduleproject.domain.constant.UsageType;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public record AccountDto(
        Long idx,
        Long userIdx,
        int cost,
        String momo
) {

}
