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
     * 사용처
     */
    @Column(name = "usageType", nullable = false)
    private UsageType usage;

    /**
     * 금액
     */
    @Column(name = "cost", nullable = false)
    private int cost;

    /**
     * 메모
     */
    @Column(name = "momo")
    private String momo;

    @Builder
    public Account(Long idx, Long userIdx, UsageType usage, int cost, String momo) {
        this.idx = idx;
        this.userIdx = userIdx;
        this.usage = usage;
        this.cost = cost;
        this.momo = momo;
    }
}
