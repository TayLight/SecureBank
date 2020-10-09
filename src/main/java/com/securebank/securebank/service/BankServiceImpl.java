package com.securebank.securebank.service;

import com.securebank.securebank.repository.ClientRepository;
import com.securebank.securebank.repository.TransactionRepository;
import org.springframework.stereotype.Service;

@Service
public class BankServiceImpl implements BankService {
    private ClientRepository clientRepository;
    private TransactionRepository transactionRepository;

    public BankServiceImpl(ClientRepository clientRepository, TransactionRepository transactionRepository) {
        this.clientRepository = clientRepository;
        this.transactionRepository=transactionRepository;
    }
}
