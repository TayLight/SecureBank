package com.securebank.securebank.repository;

import com.securebank.securebank.entity.Transact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transact, Integer> {
}
