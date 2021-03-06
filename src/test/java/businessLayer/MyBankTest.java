package businessLayer;

import dataLayer.entitites.Account;
import dataLayer.entitites.MyBank;
import dataLayer.entitites.User;
import org.junit.*;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MyBankTest {

    private MyBank myBank;
    private Account acc;

    @Before
    public void Setup() {
        Map<Integer, Account> mockCollection = new HashMap<>();
        Customer customerMock = mock(Customer.class);
        when(customerMock.getCprNumber()).thenReturn(1000);
        acc = new Account(mock(MyBank.class), customerMock, 123);
        mockCollection.put(acc.getNumber(), acc);
        myBank = new MyBank(0, "testbank", mockCollection);
    }

    @After
    public void after(){
        myBank.setBankAccounts(new HashMap());
    }

    @Test
    public void testGetAccount() {
        Assert.assertEquals(myBank.getAccount(123), acc);
    }

    @Test
    public void registerAccountTest() {
        Assert.assertNull(myBank.getAccount(1234));
        Customer customerMock = mock(Customer.class);
        when( customerMock.getCprNumber() ).thenReturn(321);
        acc = new Account(mock(MyBank.class), customerMock, 321);
        myBank.registerAccount(acc);
        Assert.assertEquals(myBank.getAccount(321), acc);
    }

    @Test
    public void getCustomer() {
        Customer customerMock = mock(Customer.class);
        when(customerMock.getCprNumber()).thenReturn(12345);
        acc = new Account(mock(MyBank.class), customerMock, 12345);
        myBank.registerAccount(acc);
        Assert.assertEquals(myBank.getCustomer(12345), customerMock);
    }

    @Test
    public void registerCustomerTest() {
        Customer customer = new User(6789, "testCustomer");
        myBank.registerCustomer(customer);
        Assert.assertEquals(myBank.getCustomer(6789), customer);
    }

    @Test
    public void getNameTest() {
        Assert.assertEquals(myBank.getName(), "testbank");
    }
}
