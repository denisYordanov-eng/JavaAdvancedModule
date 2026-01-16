package OOPBasic;

public class BankAccount {
    private int id;

    private double balance;

    public BankAccount() {

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

    public void depositAmount(double amount) {
        if (isValidDeposit(amount)) {
            this.balance += amount;
        }
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
}
