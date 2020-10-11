package com.securebank.securebank.controller;

import com.securebank.securebank.entity.Client;
import com.securebank.securebank.entity.Employee;
import com.securebank.securebank.entity.Result;
import com.securebank.securebank.entity.Transact;
import com.securebank.securebank.service.BankServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping()
@Validated
@CrossOrigin(origins = "http://localhost:4200")
public class BankController {
    private final BankServiceImpl bankService;

    @Autowired
    public BankController(BankServiceImpl bankService) {
        this.bankService = bankService;
    }

    @RequestMapping("/")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject(bankService.getAllDepartment().get(0));
        return  modelAndView;
    }

    @PostMapping("transact")
    public Result transact(@RequestBody Transact transact, @RequestBody Client sender, @RequestBody Employee employee){
        if(bankService.setTransaction(transact,sender,employee)) return new Result(true, "Успешно!");
        return new Result(false, "Отклонено!");
    }
}