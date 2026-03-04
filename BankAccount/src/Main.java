import java.util.Scanner;

/**
 * A simple bank account class that holds a balance and allows deposits,
 * withdrawals, and balance inquiries.
 */
class BankAccount {
    private double balance;

    /**
     * Constructs a new bank account with an initial balance of 0.
     */
    public BankAccount() {
        balance = 0.0;
    }

    /**
     * Deposits the specified amount into the account.
     * @param amount the amount to deposit (must be positive)
     */
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("Successfully deposited $%.2f.%n", amount);
        } else {
            System.out.println("Deposit amount needs to be positive.%n");
        }
    }

    /**
     * Withdraws the specified amount from the account if sufficient balance exists.
     * @param amount the amount to withdraw (must be positive)
     */
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount needs to be positive.%n");
        } else if (amount > balance) {
            System.out.println("Insufficient funds. Your withdrawal was denied .%n");
        } else {
            balance -= amount;
            System.out.printf("Successfully withdrew $%.2f.%n", amount);
        }
    }

    /**
     * Returns the current balance.
     * @return the balance
     */
    public double getBalance() {
        return balance;
    }
}

/**
 * Main class with a menu-driven console interface for the bank account.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account = new BankAccount();
        int choice;

        System.out.println("Welcome to Basic Bank Account Simulator!");

        do {
            // Display menu
            System.out.println("\n--- Menu ---");
            System.out.println("\nWhat would you like to do.\n");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Quit");
            System.out.print("Enter your choice (1-4): ");

            // Read user choice
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Please enter a number (1-4): ");
                scanner.next(); // consume invalid token
            }
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: $ \n");
                    while (!scanner.hasNextDouble()) {
                        System.out.print("Invalid amount. Please enter a number: $ %n");
                        scanner.next();
                    }
                    double depositAmt = scanner.nextDouble();
                    account.deposit(depositAmt);
                    break;

                case 2:
                    System.out.print("Enter withdrawal amount: $\n");
                    while (!scanner.hasNextDouble()) {
                        System.out.print("Invalid amount. Please enter a number: $ %n");
                        scanner.next();
                    }
                    double withdrawAmt = scanner.nextDouble();
                    account.withdraw(withdrawAmt);
                    break;

                case 3:
                    System.out.printf("Current balance: $%.2f%n", account.getBalance());
                    break;

                case 4:
                    System.out.println("Thank you for using the bank simulator. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please select 1, 2, 3, or 4.");
            }
        } while (choice != 4);

        scanner.close();
    }
}