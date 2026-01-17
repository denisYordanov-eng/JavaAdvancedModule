package BankAccount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BankAccountInterestRateMain {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<Integer, BankAccountInterestRate> bankAccounts = new HashMap<>();

        String command = br.readLine();

        while (!command.equals("End")) {
            String[] tokens = command.split("\\s+");
            String currentCommand = tokens[0];
            switch (currentCommand) {
                case "Create":
                    create(bankAccounts);
                    break;
                case "Deposit":
                    makeDeposit(tokens, bankAccounts);
                    break;
                case "Withdraw":
                    makeWithdraw(tokens, bankAccounts);
                    break;
                case "Print":
                    printTheBankAccInfo(tokens, bankAccounts);
                    break;
                case "GetInterest":
                    getInterest(tokens, bankAccounts);
                    break;
                case "SetInterest":
                    double interest = Double.parseDouble(tokens[1]);
                    BankAccountInterestRate.setInterest(interest);
                    break;
            }
            command = br.readLine();
        }

    }

    private static void getInterest(String[] tokens, HashMap<Integer, BankAccountInterestRate> bankAccounts) {
        int id = Integer.parseInt(tokens[1]);
        int years = Integer.parseInt(tokens[2]);
        if (bankAccounts.containsKey(id)) {
            BankAccountInterestRate bankAccountInterestRate = bankAccounts.get(id);
            double interest = bankAccountInterestRate.getInterest(years);
            System.out.printf("%.2f%n", interest);
        } else {
            System.out.println("Account does not exist");
        }
    }

    private static void create(HashMap<Integer, BankAccountInterestRate> bankAccounts) {
        BankAccountInterestRate bankAccountInterestRate = new BankAccountInterestRate();
        bankAccounts.put(bankAccountInterestRate.getId(), bankAccountInterestRate);
        System.out.printf("Account ID%d created%n", bankAccountInterestRate.getId());
    }

    private static void printTheBankAccInfo(String[] tokens, HashMap<Integer, BankAccountInterestRate> bankAccounts) {
        int id = Integer.parseInt(tokens[1]);
        if (bankAccounts.containsKey(id)) {
            BankAccountInterestRate bankAccountInterestRate = bankAccounts.get(id);
            int targetId = bankAccountInterestRate.getId();
            double targetBalance = bankAccountInterestRate.getBalance();
            System.out.printf("Account ID%d, balance %.2f%n", targetId, targetBalance);
        } else {
            System.out.println("Account does not exist");
        }
    }

    private static void makeWithdraw(String[] tokens, HashMap<Integer, BankAccountInterestRate> bankAccounts) {
        int id = Integer.parseInt(tokens[1]);
        double amount = Double.parseDouble(tokens[2]);
        if (!bankAccounts.containsKey(id)) {
            System.out.println("Account does not exist");
            return;
        }
        if (bankAccounts.get(id).isItValidWithdraw(amount, bankAccounts.get(id).getBalance())) {
            bankAccounts.get(id).withdraw(amount);
        } else {

            System.out.println("Insufficient balance");
        }
    }

    private static void makeDeposit(String[] tokens, HashMap<Integer, BankAccountInterestRate> bankAccounts) {
        int id = Integer.parseInt(tokens[1]);
        double amount = Double.parseDouble(tokens[2]);
        if (bankAccounts.containsKey(id)) {
            bankAccounts.get(id).deposit(amount);
            System.out.printf("Deposited %.0f to ID%d%n", amount, id);
        } else {
            System.out.println("Account does not exist");
        }
    }
}
