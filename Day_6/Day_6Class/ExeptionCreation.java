import java.util.Scanner;

class BalanceException extends Exception {
	public BalanceException(String message) {
		super(message);
	}
}

public class ExeptionCreation {
	static void withdraw(double balance, double amount)
			throws BalanceException {
		if (amount > balance) {
			throw new BalanceException("Withdrawal amount exceeds the available balance.");
		}

		System.out.println("Withdrawal successful. Remaining balance: "
				+ (balance - amount));
	}
    static void deposit(double balance, double amount)
            throws BalanceException {
        if (amount > 5000) {
            throw new BalanceException("Deposit amount exceeds the maximum limit(5000).");
        }
        System.out.println("Deposit successful. Updated balance: " + (balance + amount));
    }

	public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in);
		double balance = 1500;
        System.out.print("Enter your choice (1 for Deposit, 2 for Withdrawal): ");
        int c = Sc.nextInt();
        switch (c) {
            case 1:
               System.out.print("Enter deposit amount: ");
               double depositAmount = Sc.nextDouble();
               try {
                    deposit(balance, depositAmount);
                } catch (BalanceException e) {
                    System.out.println("Error: " + e.getMessage());
                    }
                break;
            case 2:
                System.out.print("Enter withdrawal amount: ");
                double withdrawAmount = Sc.nextDouble();
                try {
                    withdraw(balance, withdrawAmount);
                } catch (BalanceException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                break;
            default:
                System.out.println("Invalid choice.");
        }


	}
}
