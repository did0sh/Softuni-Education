package StaticIdAndRateTask;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, BankAccount> accounts = new HashMap<>();

        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int count = 1;
        while (!"end".equalsIgnoreCase(input)){
            String[] commandArgs = input.split("\\s+");
            String command = commandArgs[0];

            switch (command){
                case "Create":
                    execCreate(count,accounts);
                    count++;
                    break;
                case "Deposit":
                    execDeposit(commandArgs, accounts);
                    break;
                case "SetInterest":
                    execSetInterest(commandArgs, accounts);
                    break;
                case "GetInterest":
                    execGetInterest(commandArgs, accounts);
                    break;
            }
            input = scan.nextLine();
        }
    }

    private static void execGetInterest(String[] commandArgs, HashMap<Integer, BankAccount> accounts) {
        int id = Integer.parseInt(commandArgs[1]);
        int years = Integer.parseInt(commandArgs[2]);
        if (!accounts.containsKey(id)){
            System.out.println("Account does not exist");
        } else {
            BankAccount acc = accounts.get(id);
            System.out.printf("%.2f%n",acc.getInterest(years));
        }
    }

    private static void execSetInterest(String[] commandArgs, HashMap<Integer, BankAccount> accounts) {
        double interestRate = Double.parseDouble(commandArgs[1]);
        BankAccount.setInterest(interestRate);
    }

    private static void execDeposit(String[] commandArgs, HashMap<Integer, BankAccount> accounts) {
        DecimalFormat df = new DecimalFormat("#.##");
        int id = Integer.parseInt(commandArgs[1]);
        double amount = Double.parseDouble(commandArgs[2]);
        if (!accounts.containsKey(id)){
            System.out.println("Account does not exist");
        } else {
           BankAccount acc = accounts.get(id);
           acc.deposit(amount);
            System.out.printf("Deposited %s to %s%n",df.format(amount), acc.toString());
        }
    }

    private static void execCreate(int count,HashMap<Integer, BankAccount> accounts) {
        BankAccount acc = new BankAccount();
        accounts.put(count,acc);
        System.out.printf("Account %s created%n", acc.toString());
    }
}
