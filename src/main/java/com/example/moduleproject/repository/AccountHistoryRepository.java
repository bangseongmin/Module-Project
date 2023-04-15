package com.example.moduleproject.repository;

import com.example.moduleproject.domain.AccountHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountHistoryRepository extends JpaRepository<AccountHistory, Long> {

    List<AccountHistory> findAllByAccountIdx(Long id);
}
