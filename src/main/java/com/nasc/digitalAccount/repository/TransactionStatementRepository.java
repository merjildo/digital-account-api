package com.nasc.digitalAccount.repository;

import com.nasc.digitalAccount.model.TransactionStatement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionStatementRepository extends JpaRepository<TransactionStatement, Long> {
}