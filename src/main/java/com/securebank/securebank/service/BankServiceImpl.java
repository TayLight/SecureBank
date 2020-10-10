package com.securebank.securebank.service;

import com.securebank.securebank.entity.Client;
import com.securebank.securebank.entity.Department;
import com.securebank.securebank.entity.Transact;
import com.securebank.securebank.repository.ClientRepository;
import com.securebank.securebank.repository.DepartmentRepository;
import com.securebank.securebank.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankServiceImpl implements BankService {
    private ClientRepository clientRepository;
    private TransactionRepository transactionRepository;
    private DepartmentRepository departmentRepository;

    public BankServiceImpl(ClientRepository clientRepository, TransactionRepository transactionRepository, DepartmentRepository departmentRepository) {
        this.clientRepository = clientRepository;
        this.transactionRepository=transactionRepository;
        this.departmentRepository= departmentRepository;
    }

    @Override
    public List<Transact> getAllTransact() {
        return transactionRepository.findAll();
    }

    @Override
    public List<Client> getAllClient() {
        return clientRepository.findAll();
    }

    @Override
    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }
}
