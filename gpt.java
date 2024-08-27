import java.util.Scanner;

public class gpt{
    private String accountNumber;
    private String depositorName;
    private char accountType;
    private double balance;
    private static final double MAX_LOAN_WITHDRAWAL = 5000.0;

    // Constructors
    public BankAccount(String accountNumber, String depositorName, char accountType) {
        this.accountNumber = accountNumber;
        this.depositorName = depositorName;
        this.accountType = accountType;
        this.balance = 0.0;
    }

    public BankAccount(String accountNumber, String depositorName, char accountType, double initialBalance) {
        this.accountNumber = accountNumber;
        this.depositorName = depositorName;
        this.accountType = accountType;
        this.balance = initialBalance;
    }

    // Methods
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0) {
            if (accountType == 'S') {
                // Savings account
                if (balance >= amount) {
                    balance -= amount;
                    System.out.println("Withdrawal successful. New balance: " + balance);
                } else {
                    System.out.println("Insufficient funds. Converting to Loan account.");
                    convertToLoanAccount();
                }
            } else if (accountType == 'L') {
                // Loan account
                if (amount <= MAX_LOAN_WITHDRAWAL) {
                    balance -= amount;
                    System.out.println("Withdrawal successful. New balance: " + balance);
                } else {
                    System.out.println("Exceeded maximum withdrawal limit for Loan account.");
                }
            }
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    public double checkBalance() {
        return balance;
    }

    public void displayInfo() {
        System.out.println("Account Information:");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Depositor Name: " + depositorName);
        System.out.println("Account Type: " + accountType);
        System.out.println("Balance: " + balance);
    }

    private void convertToLoanAccount() {
        accountType = 'L';
        System.out.println("Account converted to Loan account.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter account details for Account 1:");
        System.out.print("Account Number: ");
        String accNumber1 = scanner.nextLine();
        System.out.print("Depositor Name: ");
        String depositorName1 = scanner.nextLine();
        System.out.print("Account Type (S or L): ");
        char accType1 = scanner.next().charAt(0);

        BankAccount account1 = new BankAccount(accNumber1, depositorName1, accType1);

        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Display Information");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account1.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    account1.withdraw(withdrawalAmount);
                    break;
                case 3:
                    System.out.println("Current balance: " + account1.checkBalance());
                    break;
                case 4:
                    account1.displayInfo();
                    break;
                case 5:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (choice != 5);

        scanner.close();
    }
}