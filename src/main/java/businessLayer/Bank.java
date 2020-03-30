package businessLayer;

import Exceptions.AccountNotFoundException;

public interface Bank {

    Account getAccount(String number) throws AccountNotFoundException;

    void registerAccount(Account account);

    Customer getCustomer(String number);

    void registerCustomer(Customer customer);

    String getName();

    String getCvr();

}