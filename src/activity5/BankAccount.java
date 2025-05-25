package activity5;

public class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private boolean isActive;

    public BankAccount(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.isActive = true;
    }

    public void deposit(double amount) {
        if (!isActive) {
            throw new IllegalStateException("Account is inactive");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        balance += amount;
    }

    public void withdraw(double amount) {
        if (!isActive) {
            throw new IllegalStateException("Account is inactive");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        if (amount > balance) {
            throw new IllegalStateException("Insufficient funds");
        }
        balance -= amount;
    }

    public void transfer(BankAccount destination, double amount) {
        if (!isActive || !destination.isActive) {
            throw new IllegalStateException("One or both accounts are inactive");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Transfer amount must be positive");
        }
        if (amount > balance) {
            throw new IllegalStateException("Insufficient funds for transfer");
        }
        this.withdraw(amount);
        destination.deposit(amount);
    }

    public void deactivate() {
        if (!isActive) {
            throw new IllegalStateException("Account is already inactive");
        }
        isActive = false;
    }

    public void activate() {
        if (isActive) {
            throw new IllegalStateException("Account is already active");
        }
        isActive = true;
    }

    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isActive() {
        return isActive;
    }
} 