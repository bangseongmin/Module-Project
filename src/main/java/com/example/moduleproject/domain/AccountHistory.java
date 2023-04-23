package com.example.moduleproject.domain;

import com.example.moduleproject.domain.constant.UsageType;
import lombok.*;

import javax.persistence.*;

@Getter
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
    @OneToOne(cascade = CascadeType.ALL) @JoinColumn(name = "accountIdx")
    private Account account;

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
    @Column(name = "cost", nullable = false)
    private int cost = 0;

    @Builder
    public AccountHistory(Account account, UsageType usage, String momo, int cost) {
        this.account = account;
        this.usage = usage;
        this.momo = momo;
        this.cost = cost;
    }
}
