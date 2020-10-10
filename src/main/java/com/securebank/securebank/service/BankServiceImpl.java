package com.securebank.securebank.service;

import com.securebank.securebank.entity.*;
import com.securebank.securebank.repository.ClientRepository;
import com.securebank.securebank.repository.DepartmentRepository;
import com.securebank.securebank.repository.TransactionRepository;
import com.securebank.securebank.repository.TransferRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankServiceImpl implements BankService {
    private ClientRepository clientRepository;
    private TransactionRepository transactionRepository;
    private DepartmentRepository departmentRepository;
    private TransferRepository transferRepository;

    public BankServiceImpl(TransferRepository transferRepository, ClientRepository clientRepository, TransactionRepository transactionRepository, DepartmentRepository departmentRepository) {
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

    @Override
    public boolean setTransaction(Transact transact, Client sender, Employee employee) {
        boolean correct= false;
        transactionRepository.save(transact);
        if(true){
            Transfer transfer = new Transfer(transact.getPayee(), sender, transact, employee);
            transferRepository.save(transfer);
        }
        return correct;
    }


}
