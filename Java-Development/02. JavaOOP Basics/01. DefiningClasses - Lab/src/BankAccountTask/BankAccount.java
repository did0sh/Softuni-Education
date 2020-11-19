package BankAccountTask;

public class BankAccount {
   private int id;
    private double balance;

    public void setId(int id){
        this.id = id;
    }

    public double getBalance(){
        return this.balance;
    }

    public void deposit(double amount){
        this.balance += amount;
    }

    public void withDraw(double amount){
        this.balance -= amount;
    }

    @Override
    public String toString(){
        return String.format("Account ID%s, balance %.2f", this.id, this.balance);
    }
}
