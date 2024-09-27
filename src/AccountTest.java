// Class representing a bank account
class AccountDetails {
    private double balance;
    // Constructor to initialize the account with an initial balance
    public AccountDetails(double initialBalance) {
        // Check if the initial balance is positive
        if (initialBalance > 0.0) {
            balance = initialBalance;
        }
    }
    // Method to credit (add) an amount to the account balance
    public void credit(double amount) {
        balance += amount;
    }
    // Method to debit (withdraw) an amount from the account balance
    public void debit(double amount) {
        // Check if the debit amount exceeds the current balance
        if (amount > balance) {
            System.out.println("Debit amount exceeded account balance.");
        } else {
            balance -= amount;
        }
    }
    // Method to get the current balance of the account
    public double getBalance() {
        return balance;
    }
}
// Class to test the functionality of the Account class
public class AccountTest {
    public static void main(String[] args) {
        // Create an Account object with an initial balance of 100.0
        AccountDetails account = new AccountDetails(100.0);
        System.out.println("Initial balance: " + account.getBalance());
        account.debit(30.0);
        System.out.println("Balance after debit of 30.0: " + account.getBalance());
        account.debit(80.0);
        System.out.println("Balance after debit of 80.0: " + account.getBalance());
    }
}
