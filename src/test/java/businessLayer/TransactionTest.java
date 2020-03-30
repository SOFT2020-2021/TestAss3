package businessLayer;

import org.junit.*;
import static org.mockito.Mockito.mock;

public class TransactionTest {

    @Test
    public void createMovement(){

        long amount =1000L;
        long timestamp = 10000L;
        var acc = new Account(mock(MyBank.class), mock(User.class), "test");

        Transaction movementTest = new Transaction(acc, amount, timestamp);

        Assert.assertEquals(movementTest.getTimestamp(),timestamp  ) ;
        Assert.assertEquals(movementTest.getAmount(),amount);
        Assert.assertEquals(movementTest.getTarget(), acc);
    }
}