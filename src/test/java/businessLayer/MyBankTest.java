package businessLayer;

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
        Map<String, Account> mockCollection = new HashMap<>();
        Customer customerMock = mock(Customer.class);
        when(customerMock.getCprNumber()).thenReturn("1000");
        acc = new Account(mock(MyBank.class), customerMock, "test");
        mockCollection.put(acc.getNumber(), acc);
        myBank = new MyBank("", "testbank", mockCollection);
    }

    @After
    public void after(){
        myBank.setBankAccounts(new HashMap());
    }

    @Test
    public void testGetAccount() {
        Assert.assertEquals(myBank.getAccount("test"), acc);
    }

    @Test
    public void registerAccountTest() {
        Assert.assertNull(myBank.getAccount("1234"));
        Customer customerMock = mock(Customer.class);
        when( customerMock.getCprNumber() ).thenReturn("test2");
        acc = new Account(mock(MyBank.class), customerMock, "test2");
        myBank.registerAccount(acc);
        Assert.assertEquals(myBank.getAccount("test2"), acc);
    }

    @Test
    public void getCustomer() {
        Customer customerMock = mock(Customer.class);
        when(customerMock.getCprNumber()).thenReturn("1234");
        acc = new Account(mock(MyBank.class), customerMock, "1234");
        myBank.registerAccount(acc);
        Assert.assertEquals(myBank.getCustomer("1234"), customerMock);
    }

    @Test
    public void registerCustomerTest() {
        Customer customer = new User("6789", "testCustomer");
        myBank.registerCustomer(customer);
        Assert.assertEquals(myBank.getCustomer("6789"), customer);
    }

    @Test
    public void getNameTest() {
        Assert.assertEquals(myBank.getName(), "testbank");
    }
}
