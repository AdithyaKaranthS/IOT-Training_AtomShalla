class LowerThanBalanceException extends Exception {
	public LowerThanBalanceException(String message) {
		super(message);
	}
}

public class ExeptionCreation {
	static void withdraw(double balance, double amount)
			throws LowerThanBalanceException {
		if (amount > balance) {
			throw new LowerThanBalanceException(
					"Balance is lower than the withdrawal amount.");
		}

		System.out.println("Withdrawal successful. Remaining balance: "
				+ (balance - amount));
	}

	public static void main(String[] args) {
		double balance = 1000;
		double amount = 1200;

		try {
			withdraw(balance, amount);
		} catch (LowerThanBalanceException e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}
}
