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

        userA.addMoneyToWallet(500);
        userA.sendMoney(userB, 200);

        System.out.println("User A:");
        userA.checkBalance();

        System.out.println();

        System.out.println("User B:");
        userB.checkBalance();
    }
}