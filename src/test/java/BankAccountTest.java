import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    @Test
    @DisplayName("withdraw 500 successfully")
    public void testWithDraw(){
        BankAccount bankAccount = new BankAccount(500,-1000);
        bankAccount.withDraw(300);
        assertEquals(200,bankAccount.getBalance());
    }

    @Test
    @DisplayName("Deposit 400 successfully ")
    public void testDeposit(){
        BankAccount bankAccount = new BankAccount(400, 0);
        bankAccount.deposit(500);
        assertEquals(900,bankAccount.getBalance());
    }

    @Test
    @DisplayName("Withdraw will become negative")
    public  void testWithDrawNotStuckAtZero(){
        BankAccount bankAccount = new BankAccount(500, -1000);
        bankAccount.withDraw(800);
        assertNotEquals(0, bankAccount.getBalance());
    }


    @Test
    @DisplayName("Test Activation Account after creation")
    public void testActive(){
        BankAccount bankAccount = new BankAccount(500,0);
        assertTrue(bankAccount.isActive());
    }

    @Test
    @DisplayName("Test display name")
    public void testHolderNameSet(){
        BankAccount bankAccount = new BankAccount(500, 0);
        bankAccount.setHolderName("Shivram");
        assertNotNull(bankAccount.getHolderName());
    }

    @Test
    @DisplayName("Test that we cannot withdraw below minimum")
    public void testNoWithDrawBelowMinimum(){
        BankAccount bankAccount = new BankAccount(500,-1000);
        assertThrows(RuntimeException.class, ()->bankAccount.withDraw(2000));
    }
}
