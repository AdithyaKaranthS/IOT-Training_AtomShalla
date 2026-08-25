import java.util.Scanner;

class BankAccount {
    private String accountNumber;
    private String bankName;
    private double balance;

    public BankAccount(String accountNumber, String bankName, double balance) {
        this.accountNumber = accountNumber;
        this.bankName = bankName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public double getBalance() {
        return balance;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}

class PhonePeUser {
    private String name;
    private String phoneNumber;
    private String upiId;
    private double walletBalance;
    private BankAccount bankAccount;

    public PhonePeUser(String name, String phoneNumber, String upiId, double walletBalance) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.upiId = upiId;
        this.walletBalance = walletBalance;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getUpiId() {
        return upiId;
    }

    public double getWalletBalance() {
        return walletBalance;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public boolean addMoneyToWallet(double amount) {
        if (bankAccount != null && bankAccount.withdraw(amount)) {
            walletBalance += amount;
            return true;
        }
        return false;
    }

    public boolean sendMoney(PhonePeUser receiver, double amount) {
        if (receiver != null && amount > 0 && amount <= walletBalance) {
            walletBalance -= amount;
            receiver.walletBalance += amount;
            return true;
        }
        return false;
    }

    public void checkBalance() {
        System.out.println("Wallet Balance: Rs." + walletBalance);

        if (bankAccount != null) {
            System.out.println("Bank Balance: Rs." + bankAccount.getBalance());
        } else {
            System.out.println("No bank account linked.");
        }
    }
}

public class PhonePeDemo {
    public static void main(String[] args) {
        BankAccount bankA = new BankAccount("ACC001", "SBI", 5000);
        BankAccount bankB = new BankAccount("ACC002", "HDFC", 3000);

        PhonePeUser userA = new PhonePeUser("User A", "9876543210", "usera@upi", 0);
        PhonePeUser userB = new PhonePeUser("User B", "9876543211", "userb@upi", 0);

        userA.setBankAccount(bankA);
        userB.setBankAccount(bankB);

        PhonePeUser[] users = { userA, userB };
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== PhonePe Demo ===");
            System.out.println("1. Add money to wallet");
            System.out.println("2. Send money");
            System.out.println("3. Check balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            String option = scanner.nextLine();

            if (option.equals("1")) {
                PhonePeUser user = chooseUser(scanner, users, "Select a user: ");
                double amount = readAmount(scanner, "Enter amount to add: ");

                if (user.addMoneyToWallet(amount)) {
                    System.out.println("Money added successfully.");
                } else {
                    System.out.println("Unable to add money. Check the amount and bank balance.");
                }
            } else if (option.equals("2")) {
                PhonePeUser sender = chooseUser(scanner, users, "Select sender: ");
                PhonePeUser receiver = chooseUser(scanner, users, "Select receiver: ");
                double amount = readAmount(scanner, "Enter amount to send: ");

                if (sender.sendMoney(receiver, amount)) {
                    System.out.println("Money sent successfully.");
                } else {
                    System.out.println("Unable to send money. Check the amount and wallet balance.");
                }
            } else if (option.equals("3")) {
                PhonePeUser user = chooseUser(scanner, users, "Select a user: ");
                user.checkBalance();
            } else if (option.equals("4")) {
                System.out.println("Thank you for using PhonePe Demo.");
                break;
            } else {
                System.out.println("Invalid option. Please choose 1 to 4.");
            }
        }

        scanner.close();
    }

    private static PhonePeUser chooseUser(Scanner scanner, PhonePeUser[] users, String prompt) {
        while (true) {
            System.out.println(prompt);
            System.out.println("1. " + users[0].getName());
            System.out.println("2. " + users[1].getName());
            System.out.print("Choose a user: ");

            String choice = scanner.nextLine();
            if (choice.equals("1")) {
                return users[0];
            }
            if (choice.equals("2")) {
                return users[1];
            }
            System.out.println("Invalid user. Please choose 1 or 2.");
        }
    }

    private static double readAmount(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                double amount = Double.parseDouble(scanner.nextLine());
                if (amount > 0) {
                    return amount;
                }
            } catch (NumberFormatException exception) {
                // Ask again when the input is not a valid number.
            }
            System.out.println("Enter a valid amount greater than zero.");
        }
    }
}