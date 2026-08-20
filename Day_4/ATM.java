import java.util.Map;
import java.util.Scanner;

class ATM {
    private static final Map<String, UserAccount> USER_ACCOUNTS = Map.of(
            "0000", new UserAccount("Alice", 1000.00),
            "1234", new UserAccount("Bob", 1500.00),
            "4321", new UserAccount("Charlie", 750.00));

    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
        String pin = readPin(Sc);
        UserAccount account = findAccount(pin);

        if (account != null) {
            showAccessGranted(account.name);
            runAtmMenu(Sc, account);
        } else {
            showAccessDenied();
        }

        Sc.close();
    }

    private static String readPin(Scanner Sc) {
        System.out.print("Enter your PIN: ");
        return Sc.nextLine();
    }

    private static UserAccount findAccount(String pin) {
        return USER_ACCOUNTS.get(pin);
    }

    private static void showAccessGranted(String userName) {
        System.out.println("Access granted. Welcome, " + userName + ".");
    }

    private static void showAccessDenied() {
        System.out.println("Invalid PIN. Access denied.");
    }

    private static void runAtmMenu(Scanner Sc, UserAccount account) {
        double balance = account.balance;
        boolean running = true;

        while (running) {
            displayMenu();
            int choice = Sc.nextInt();

            switch (choice) {
                case 1:
                    displayBalance(balance);
                    break;
                case 2:
                    balance = depositMoney(Sc, balance);
                    break;
                case 3:
                    balance = withdrawMoney(Sc, balance);
                    break;
                case 4:
                    showExitMessage();
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1, 2, 3, or 4.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n--- ATM Menu ---");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void displayBalance(double balance) {
        System.out.printf("Current balance: $%.2f%n", balance);
    }

    private static double depositMoney(Scanner Sc, double balance) {
        System.out.print("Enter deposit amount: $");
        double deposit = Sc.nextDouble();

        if (deposit > 0) {
            balance += deposit;
            System.out.printf("Deposit successful. New balance: $%.2f%n", balance);
        } else {
            System.out.println("Deposit amount must be greater than zero.");
        }

        return balance;
    }

    private static double withdrawMoney(Scanner Sc, double balance) {
        System.out.print("Enter withdrawal amount: $");
        double withdrawal = Sc.nextDouble();

        if (withdrawal <= 0) {
            System.out.println("Withdrawal amount must be greater than zero.");
        } else if (withdrawal > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= withdrawal;
            System.out.printf("Please collect your cash. New balance: $%.2f%n", balance);
        }

        return balance;
    }

    private static void showExitMessage() {
        System.out.println("Thank you for using the ATM. Goodbye!");
    }

    private static class UserAccount {
        private final String name;
        private final double balance;

        private UserAccount(String name, double balance) {
            this.name = name;
            this.balance = balance;
        }
    }
}