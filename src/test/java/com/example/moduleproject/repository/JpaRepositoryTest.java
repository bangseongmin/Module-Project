package com.example.moduleproject.repository;

import com.example.moduleproject.domain.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("JPA 연결 테스트")
@DataJpaTest
class JpaRepositoryTest {

    private final MemberRepository memberRepository;

    public JpaRepositoryTest(@Autowired MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @DisplayName("회원 정보 select 테스트")
    @Test
    void givenUserAccounts_whenSelecting_thenReturnUserAccounts() {
        // Given

        // When
        List<Member> userAccounts = memberRepository.findAll();

        //Then
        assertThat(userAccounts)
                .isNotNull()
                .hasSize(4);
    }

    @DisplayName("회원 정보 insert 테스트")
    @Test
    void givenUserAccount_whenInserting_thenWorksFine() {
        // Given
        long previousCount = memberRepository.count();
        Member member = Member.builder()
                .username("test")
                .password("test")
                .age(18)
                .fullname("test")
                .birthday(LocalDate.now())
                .build();

        // When
        memberRepository.save(member);

        // Then
        assertThat(memberRepository.count()).isEqualTo(previousCount + 1);
    }

    @DisplayName("회원 정보 update 테스트")
    @Test
    void givenUserAccountAndRoleType_whenUpdating_thenWorksFine() {
        // Given
        Member member = memberRepository.getReferenceById(1L);
        member.updatePassword("updatedPw");

        // When
        Member updatedMember = memberRepository.saveAndFlush(member);

        // Then
        assertThat(updatedMember)
                .hasFieldOrPropertyWithValue("username", "test1")
                .hasFieldOrPropertyWithValue("password", "updatedPw");
    }

    @DisplayName("회원 정보 delete 테스트")
    @Test
    void givenUserAccount_whenDeleting_thenWorksFine() {
        // Given
        long previousCount = memberRepository.count();
        Member member = memberRepository.getReferenceById(1L);

        // When
        memberRepository.delete(member);

        // Then
        assertThat(memberRepository.count()).isEqualTo(previousCount - 1);
    }

}
