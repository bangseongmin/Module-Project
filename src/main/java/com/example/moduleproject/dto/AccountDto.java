package com.example.moduleproject.dto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public record AccountDto(
        Long accountIdx,
        String type,
        int cost,
        String momo
) {


}
