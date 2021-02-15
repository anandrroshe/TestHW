package HW19;

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        Thread thread = new Thread(new AccountHolder(account));
        Thread thread1 = new Thread(new AccountHolder(account));
        thread.run();



    }
}
