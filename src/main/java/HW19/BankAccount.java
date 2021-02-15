package HW19;

public class BankAccount {
    private int balance = 0;

    public int getBalance(){
        return balance;
    }

    public void withdrawCash(int amount){
        balance = balance - amount;
    }

    public void addCash(int amount){
        balance = balance + amount;
    }
}
