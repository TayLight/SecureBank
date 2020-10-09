package com.securebank.securebank.controller;

import com.securebank.securebank.entity.Transact;
import com.securebank.securebank.service.BankServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
@CrossOrigin(origins = "http://localhost:4200")
public class BankController {
    private final BankServiceImpl bankService;

    @Autowired
    public BankController(BankServiceImpl bankService) {
        this.bankService = bankService;
    }


    public Transact getTransact()
}
