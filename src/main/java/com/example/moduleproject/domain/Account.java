package com.example.moduleproject.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@Entity
public class Account {

    /**
     * 계좌 인덱스
     */
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    /**
     * 회원 인덱스
     */
    @Column(name = "userIdx", nullable = false)
    private Long userIdx;

    /**
     * 잔액
     */
    @Builder.Default @Column(name = "balance", nullable = false)
    private int balance = 0;

    @Builder
    public Account(Long idx, Long userIdx, int balance) {
        this.idx = idx;
        this.userIdx = userIdx;
        this.balance = balance;
    }
}
