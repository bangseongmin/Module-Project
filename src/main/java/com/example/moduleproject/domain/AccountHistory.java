package com.example.moduleproject.domain;

import com.example.moduleproject.domain.constant.UsageType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@Table(name = "account_history")
@Entity
public class AccountHistory {

    /**
     * 계좌 인덱스
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;


    /**
     * 계좌 인덱스
     */
    @Column(name = "accountIdx")
    private Long accountIdx;

    /**
     * 사용처
     */
    @Column(name = "usageType")
    private UsageType usage;

    /**
     * 메모
     */
    @Column(name = "momo")
    private String momo;

    /**
     * 금액
     */
    @Builder.Default @Column(name = "cost", nullable = false)
    private int cost = 0;

    @Builder
    public AccountHistory(Long accountIdx, UsageType usage, String momo, int cost) {
        this.accountIdx = accountIdx;
        this.usage = usage;
        this.momo = momo;
        this.cost = cost;
    }
}
