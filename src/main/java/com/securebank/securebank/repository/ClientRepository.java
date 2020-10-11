package com.securebank.securebank.repository;

import com.securebank.securebank.entity.Account;
import com.securebank.securebank.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    Account findAccountByIdClient(int idClient);
}
