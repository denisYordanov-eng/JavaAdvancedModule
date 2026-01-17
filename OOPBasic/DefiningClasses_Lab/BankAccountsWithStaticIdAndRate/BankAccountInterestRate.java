package BankAccount;

public class BankAccountInterestRate {
    private final static double DEFAULT_INTEREST = 0.02;

   private static double rate = DEFAULT_INTEREST;

   private static int accountCount;

    private int id;

    private double balance;

    public BankAccountInterestRate() {
        this.id = ++accountCount;
    }

    public static void setInterest(double interest) {
        rate = interest;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (isValidDeposit(amount)) {
            this.balance += amount;
        }
    }

    public double getInterest(int years) {
        return this.balance * rate * years;
    }

    public void withdraw(double amount) {
        if (isItValidWithdraw(amount, this.balance)) {
            this.balance -= amount;
        }
    }

    public boolean isValidDeposit(double amount) {
        boolean isValidDeposit = false;
        if (amount > 0) {
            isValidDeposit = true;
        }
        return isValidDeposit;
    }

    public boolean isItValidWithdraw(double amount, double balance) {
        boolean isItValidWithdraw = false;
        if (balance >= amount) {
            isItValidWithdraw = true;
        }
        return isItValidWithdraw;
    }

    @Override
    public String toString() {
        return "ID" + this.id;
    }
}
