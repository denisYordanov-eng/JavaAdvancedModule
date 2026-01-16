package OOPBasic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BankAccountMain {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<Integer, BankAccount> bankAccounts = new HashMap<>();

        String command = br.readLine();

        while (!command.equals("End")) {
            String[] tokens = command.split("\\s+");
            String currentCommand = tokens[0];
            switch (currentCommand) {
                case "Create":
                    makeCreate(tokens, bankAccounts);
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
            }
            command = br.readLine();
        }

    }

    private static void printTheBankAccInfo(String[] tokens, HashMap<Integer, BankAccount> bankAccounts) {
        int id = Integer.parseInt(tokens[1]);
        if (bankAccounts.containsKey(id)) {
            BankAccount bankAccount = bankAccounts.get(id);
            int targetId = bankAccount.getId();
            double targetBalance = bankAccount.getBalance();
            System.out.printf("Account ID%d, balance %.2f%n", targetId, targetBalance);
        } else {
            System.out.println("Account does not exist");
        }
    }

    private static void makeWithdraw(String[] tokens, HashMap<Integer, BankAccount> bankAccounts) {
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

    private static void makeDeposit(String[] tokens, HashMap<Integer, BankAccount> bankAccounts) {
        int id = Integer.parseInt(tokens[1]);
        double amount = Double.parseDouble(tokens[2]);
        if (bankAccounts.containsKey(id)) {
            bankAccounts.get(id).depositAmount(amount);
        } else {
            System.out.println("Account does not exist");
        }
    }

    private static void makeCreate(String[] tokens, HashMap<Integer, BankAccount> bankAccounts) {
        int id = Integer.parseInt(tokens[1]);
        if (bankAccounts.containsKey(id)) {
            System.out.println("Account already exists");
        } else {
            BankAccount bankAccount = new BankAccount();
            bankAccount.setId(id);
            bankAccounts.put(id, bankAccount);
        }
    }
}
