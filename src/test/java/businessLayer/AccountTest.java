package businessLayer;

import Exceptions.AccountNotFoundException;
import org.junit.*;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class AccountTest {

    MyBank bank;
    Customer customer;
    String accountNumber;
    Account account;
    Account target;

    @Before
    public void setup(){
        bank = mock(MyBank.class);
        customer = mock(Customer.class);
        accountNumber = "ABC12345";
        var targetNumber = "TGT12345";
        account = new Account(bank, customer, accountNumber);
        target = new Account(bank, customer, targetNumber);
        var accounts = new HashMap<String, Account>();
        accounts.put(accountNumber,account);
        accounts.put(targetNumber, target);
        bank.setBankAccounts(accounts);
    }

    @After
    public void teardown(){
        bank = null;
        customer = null;
        accountNumber = null;
        account = null;
        target = null;
    }

    @Test
    public void testCreateAccount() throws Exception {
        assertNotNull(account);
    }

    @Test
    public void testCreateAccountWithBank() {
        assertEquals(bank, account.getBank());
        assertNotNull(account.getBank());
    }

    @Test
    public void testCreateAccountWithNumber() {
        assertEquals(accountNumber, account.getNumber());
        assertNotNull(account.getNumber());
    }

    @Test
    public void testCreateAccountWithZeroBalance() {
        assertEquals(0L, account.getBalance());
    }

    @Test
    public void testTransferPositiveAmount() {
        int targetTransactionsSizeBefore = target.getTransactions().size();
        int sourceTransactionsSizeBefore = account.getTransactions().size();

        Exception exception = assertThrows(AccountNotFoundException.class, () -> {
            account.transfer(100, "I do not exist");
        });

        when(bank.getAccount(anyString())).thenReturn(target);
        try {
            account.transfer(10000, target.getNumber());
            assertEquals(targetTransactionsSizeBefore + 1, target.getTransactions().size());
            assertEquals(sourceTransactionsSizeBefore + 1, account.getTransactions().size());
            assertEquals(-10000, account.getBalance());
            assertEquals(10000, target.getBalance());
        }catch(AccountNotFoundException e) {
            fail();
        }
    }
}