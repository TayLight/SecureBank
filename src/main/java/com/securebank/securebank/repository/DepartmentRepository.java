package com.securebank.securebank.repository;

import com.securebank.securebank.entity.Account;
import com.securebank.securebank.entity.Deparment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Deparment, Integer> {
}
