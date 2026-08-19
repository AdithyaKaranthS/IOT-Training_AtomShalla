import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double balance = 1000.00;
        boolean running = true;

        while (running) {
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.printf("Current balance: $%.2f%n", balance);
                    break;

                case 2:
                    System.out.print("Enter deposit amount: $");
                    double deposit = scanner.nextDouble();
                    if (deposit > 0) {
                        balance += deposit;
                        System.out.printf("Deposit successful. New balance: $%.2f%n", balance);
                    } else {
                        System.out.println("Deposit amount must be greater than zero.");
                    }
                    break;

                case 3:
                    System.out.print("Enter withdrawal amount: $");
                    double withdrawal = scanner.nextDouble();
                    if (withdrawal <= 0) {
                        System.out.println("Withdrawal amount must be greater than zero.");
                    } else if (withdrawal > balance) {
                        System.out.println("Insufficient balance.");
                    } else {
                        balance -= withdrawal;
                        System.out.printf("Please collect your cash. New balance: $%.2f%n", balance);
                    }
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please select 1, 2, 3, or 4.");
            }
        }

        scanner.close();
    }
}