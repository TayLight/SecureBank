package com.securebank.securebank.controller;

import com.securebank.securebank.entity.Transact;
import com.securebank.securebank.service.BankServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping()
@CrossOrigin(origins = "http://localhost:4200")
public class BankController {
    private final BankServiceImpl bankService;

    @Autowired
    public BankController(BankServiceImpl bankService) {
        this.bankService = bankService;
    }

    @GetMapping("all")
    public List<Transact> getAll(){
        LinkedList<Transact> transacts =  new LinkedList<Transact>();
        transacts.add(new Transact());
        return transacts;
    }
}