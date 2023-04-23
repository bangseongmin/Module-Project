package com.example.moduleproject.service;

import com.example.moduleproject.domain.Account;
import com.example.moduleproject.domain.AccountHistory;
import com.example.moduleproject.domain.Member;
import com.example.moduleproject.domain.constant.UsageType;
import com.example.moduleproject.dto.AccountDto;
import com.example.moduleproject.dto.MemberDto;
import com.example.moduleproject.repository.AccountHistoryRepository;
import com.example.moduleproject.repository.AccountRepository;
import com.example.moduleproject.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final AccountHistoryRepository accountHistoryRepository;

    /**
     * 사용자 가계부 계좌 등록
     * @param member
     */
    public void createAccount(Member member) {
        accountRepository.save(Account.builder()
                .member(member)
                .build());
    }

    /**
     * 기록하기(가계부 기록)
     * @param request
     */
    @Transactional
    public void writeHistory(AccountDto request) {
        /**
         * 1. 사용 기록
         * 2. 계좌 금액 최신화
         */

       Account account = accountRepository.findById(request.accountIdx()).orElseThrow();
       accountHistoryRepository.save(AccountHistory.builder()
                .account(account)
                .usage(UsageType.valueOf(request.type()))
                .cost(request.cost())
                .momo(request.momo())
                .build());

        List<AccountHistory> histories = accountHistoryRepository.findAllByAccount_Idx(request.accountIdx());
        account.updateCost(histories.stream().map(AccountHistory::getCost).mapToInt(cost -> cost).sum());
    }

    /**
     * 기록 취소
     * @param idx
     */
    public void deleteHistory(Long idx) {
        accountHistoryRepository.deleteById(idx);
    }
}
