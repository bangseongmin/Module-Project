package com.example.moduleproject.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Table(name = "account")
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
    @OneToOne(cascade = CascadeType.ALL) @JoinColumn(name = "memberId")
    private Member member;

    /**
     * 잔액
     */
    @Column(name = "balance", nullable = false)
    private int balance = 0;

    @Builder
    public Account(Member member, int balance) {
        this.member = member;
        this.balance = balance;
    }

    public void updateCost(int balance) {
        this.balance = balance;
    }
}
