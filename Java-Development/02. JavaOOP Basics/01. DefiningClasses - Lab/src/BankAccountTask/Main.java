package BankAccountTask;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, BankAccount> accounts = new HashMap<>();

        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        while (!"end".equalsIgnoreCase(input)){
            String[] commandArgs= input.split("\\s+");
            String command = commandArgs[0];

            switch (command){
                case "Create":
                    executeCreate(commandArgs,accounts);
                    break;
                case "Deposit":
                    executeDeposit(commandArgs, accounts);
                    break;
                case "Withdraw":
                    executeWithdraw(commandArgs, accounts);
                    break;
                case "Print":
                    executePrint(commandArgs,accounts);
                    break;
            }

            input = scan.nextLine();
        }
    }

    private static void executePrint(String[] commandArgs, HashMap<Integer, BankAccount> accounts) {
        int id = Integer.parseInt(commandArgs[1]);
        if (!accounts.containsKey(id)){
            System.out.println("Account does not exist");
        } else {
            System.out.println(accounts.get(id));
        }
    }

    private static void executeWithdraw(String[] commandArgs, HashMap<Integer, BankAccount> accounts) {
        int id = Integer.parseInt(commandArgs[1]);
        int amount = Integer.parseInt(commandArgs[2]);

        if (!accounts.containsKey(id)){
            System.out.println("Account does not exist");
        } else if (amount > accounts.get(id).getBalance()){
            System.out.println("Insufficient balance");
        } else {
            BankAccount acc = accounts.get(id);
            acc.withDraw(amount);
        }
    }

    private static void executeDeposit(String[] commandArgs, HashMap<Integer, BankAccount> accounts) {
        int id = Integer.parseInt(commandArgs[1]);
        int amount = Integer.parseInt(commandArgs[2]);

        if (!accounts.containsKey(id)){
            System.out.println("Account does not exist");
        } else {
            BankAccount acc = accounts.get(id);
            acc.deposit(amount);
        }

    }

    private static void executeCreate(String[] commandArgs, HashMap<Integer, BankAccount> accounts) {
        int id = Integer.parseInt(commandArgs[1]);
        if (accounts.containsKey(id)){
            System.out.println("Account already exists");
        } else {
            BankAccount acc = new BankAccount();
            acc.setId(id);
            accounts.put(id, acc);
        }
    }
}
