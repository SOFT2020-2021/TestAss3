package businessLayer.controllers;

import businessLayer.*;
import contract.Contract;
import contract.transferables.AccountTransferable;

import java.util.HashMap;
import java.util.List;

public class AccountController implements EntityController<AccountTransferable>{

    public Contract getAccount(String number){
        //TODO fetch a user from the datalayer
        Customer customer = new User("2212201111", "Sven");
        Bank bank = new MyBank("321321", "Nordea", new HashMap<String, Account>());
        Account acc = new Account(bank, customer, number);
        return (Contract<AccountTransferable>) new AccountTransferable(acc.getCustomer().getCprNumber(),bank.getCvr(), number, acc.getBalance());
    }

    @Override
    public Contract<AccountTransferable> getOne() {
        return null;
    }

    @Override
    public List<Contract<AccountTransferable>> getMany() {
        return null;
    }

    @Override
    public boolean deleteOne() {
        return false;
    }

    @Override
    public boolean deleteMany() {
        return false;
    }

    @Override
    public boolean persist() {
        return false;
    }

    @Override
    public boolean update() {
        return false;
    }
}
