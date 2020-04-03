package businessLayer.controllers;

import businessLayer.*;
import contract.Contract;
import contract.transferables.AccountTransferable;
import dataLayer.entitites.Account;
import dataLayer.entitites.MyBank;
import dataLayer.entitites.User;

import java.util.HashMap;
import java.util.List;

public class AccountController implements EntityController<AccountTransferable> {

    public Contract getAccount(int number){
        //TODO fetch a user from the datalayer
        Customer customer = new User(2201111, "Sven");
        Bank bank = new MyBank(321321, "Nordea", new HashMap<Integer, Account>());
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
