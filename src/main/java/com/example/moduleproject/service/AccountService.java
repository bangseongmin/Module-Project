package com.example.moduleproject.service;

import com.example.moduleproject.domain.Account;
import com.example.moduleproject.dto.AccountDto;
import com.example.moduleproject.dto.MemberDto;
import com.example.moduleproject.repository.AccountHistoryRepository;
import com.example.moduleproject.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final AccountHistoryRepository accountHistoryRepository;

    /**
     * 사용자 가계부 계좌 등록
     * @param member
     */
    public void createAccount(MemberDto member) {
        accountRepository.save(Account.builder()
                .userIdx(member.idx())
                .build());
    }

    /**
     * 기록하기(가계부 기록)
     * @param request
     */
    public void writeHistory(AccountDto request) {
        /**
         * 1. 사용 기록
         * 2. 계좌 금액 최신화
         */
    }
}
