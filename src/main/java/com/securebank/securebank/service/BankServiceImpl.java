package com.securebank.securebank.service;

import com.securebank.securebank.entity.*;
import com.securebank.securebank.repository.ClientRepository;
import com.securebank.securebank.repository.DepartmentRepository;
import com.securebank.securebank.repository.TransactionRepository;
import com.securebank.securebank.repository.TransferRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

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
        transactionRepository.save(transact);
        boolean check = antiFrode(transact.getPayee(), sender);
        if (check) { //Вот это условие, где будет лежать проверка
            Transfer transfer = new Transfer(transact.getPayee(), sender, transact, employee);
            transferRepository.save(transfer);
        }
        return check;
    }

    public boolean antiFrode(Client numberOne, Client numberTwo) {
        Random r = new Random();
        double p = Math.abs(r.nextDouble());
        if (p <= 0.01) { //второй акк оказывается в списке банов. примерно 1% номеров в бане
            String ban = clientRepository.findAccountByIdClient(numberTwo.getIdClient()).getAccountNumber(); //моделируем бан лист, в данном случае в бане счет получателя
            if (clientRepository.findAccountByIdClient(numberOne.getIdClient()).getAccountNumber().equals(ban) || numberOne.getTelephoneClient() == ban || clientRepository.findAccountByIdClient(numberTwo.getIdClient()).getAccountNumber() == ban || numberTwo.getTelephoneClient() == ban) {
                System.out.println("Номер в бане");
                return false; //запрещаем транзакцию
            }
        } else { // оба аккаунта не в бане
            if (numberOne.getCountConf() <= 0.15 || numberTwo.getCountConf() <= 0.15) { //если рейтинг доверия низкий у одного из пользователей
                System.out.println("Низкий рейтинг");
                System.out.println(numberOne.getCountConf() + " " + numberTwo.getCountConf());
                return false; //запрещаем транзакцию
            } else {
                if (numberOne.getCountConf() >= 0.8 && numberTwo.getCountConf() >= 0.8) {
                    System.out.println("Высокое доверие");
                    System.out.println(numberOne.getCountConf() + " " + numberTwo.getCountConf());
                    return true; // если у обоих высокая степень доверенности, то разрешаем транзакцию
                } else {
                    // *проверьте правильность введенных данных*
                    // *Введите последние CVV карты* 3 попытки
                    int i = 0;
                    while (i < 3) {
                        double confCVV = Math.abs(r.nextDouble()); //некий шанс того, что CVV будет введен правильно
                        if (confCVV > 0.5) {
                            System.out.println("CVV введен верно");
                            break;
                        }
                        if (i == 2) {
                            System.out.println("CVV введен не верно");
                            return false;
                        }
                        i++;
                    }
                    // *отправьте селфи с паспортом, 2 попытки
                    // если пользователь дошел до этого, то он отправит либо нажмет кнопку выхода, что отследить тут я не могу за отсутствием форм
                    i = 0;
                    while (i < 2) {
                        double confCons = Math.abs(r.nextDouble()); // некий шанс того, что фрод-аналитик разрешит или забанит операцию
                        if (confCons > 0.5) {
                            System.out.println("Аналитик пустил");
                            return true;
                        }
                        if (i == 1) {
                            System.out.println("Аналитик не пустил");
                            return false;
                        }
                        i++;
                    }

                }
            }
        }
        return false;
    }

}