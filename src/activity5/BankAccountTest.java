package activity5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {
    private BankAccount account;
    private static final String ACCOUNT_NUMBER = "1234567890";
    private static final String ACCOUNT_HOLDER = "John Doe";
    private static final double INITIAL_BALANCE = 1000.0;

    @BeforeEach
    void setUp() {
        account = new BankAccount(ACCOUNT_NUMBER, ACCOUNT_HOLDER, INITIAL_BALANCE);
    }

    @Test
    void testInitialState() {
        // Test initial account state
        assertEquals(ACCOUNT_NUMBER, account.getAccountNumber());
        assertEquals(ACCOUNT_HOLDER, account.getAccountHolder());
        assertEquals(INITIAL_BALANCE, account.getBalance());
        assertTrue(account.isActive());
    }

    @Test
    void testDeposit() {
        // Test successful deposit
        account.deposit(500.0);
        assertEquals(1500.0, account.getBalance());

        // Test deposit with zero amount
        assertThrows(IllegalArgumentException.class, () -> account.deposit(0.0));

        // Test deposit with negative amount
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-100.0));

        // Test deposit on inactive account
        account.deactivate();
        assertThrows(IllegalStateException.class, () -> account.deposit(100.0));
    }

    @Test
    void testWithdraw() {
        // Test successful withdrawal
        account.withdraw(500.0);
        assertEquals(500.0, account.getBalance());

        // Test withdrawal with zero amount
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(0.0));

        // Test withdrawal with negative amount
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-100.0));

        // Test withdrawal with insufficient funds
        assertThrows(IllegalStateException.class, () -> account.withdraw(2000.0));

        // Test withdrawal on inactive account
        account.deactivate();
        assertThrows(IllegalStateException.class, () -> account.withdraw(100.0));
    }

    @Test
    void testTransfer() {
        BankAccount destination = new BankAccount("0987654321", "Jane Doe", 500.0);

        // Test successful transfer
        account.transfer(destination, 300.0);
        assertEquals(700.0, account.getBalance());
        assertEquals(800.0, destination.getBalance());

        // Test transfer with zero amount
        assertThrows(IllegalArgumentException.class, () -> account.transfer(destination, 0.0));

        // Test transfer with negative amount
        assertThrows(IllegalArgumentException.class, () -> account.transfer(destination, -100.0));

        // Test transfer with insufficient funds
        assertThrows(IllegalStateException.class, () -> account.transfer(destination, 2000.0));

        // Test transfer with inactive source account
        account.deactivate();
        assertThrows(IllegalStateException.class, () -> account.transfer(destination, 100.0));

        // Test transfer with inactive destination account
        account.activate();
        destination.deactivate();
        assertThrows(IllegalStateException.class, () -> account.transfer(destination, 100.0));
    }

    @Test
    void testAccountActivation() {
        // Test deactivation
        account.deactivate();
        assertFalse(account.isActive());

        // Test reactivation
        account.activate();
        assertTrue(account.isActive());

        // Test deactivating already inactive account
        account.deactivate();
        assertThrows(IllegalStateException.class, () -> account.deactivate());

        // Test activating already active account
        account.activate();
        assertThrows(IllegalStateException.class, () -> account.activate());
    }
} 