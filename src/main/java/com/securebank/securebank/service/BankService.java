package com.securebank.securebank.service;

import com.securebank.securebank.entity.Client;
import com.securebank.securebank.entity.Department;
import com.securebank.securebank.entity.Transact;

import java.util.List;

public interface BankService {

    List<Transact> getAllTransact();
    List<Client> getAllClient();
    List<Department> getAllDepartment();
}
