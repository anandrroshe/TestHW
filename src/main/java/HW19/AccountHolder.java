package HW19;

import java.util.Scanner;

public class AccountHolder implements Runnable {
    private BankAccount account;

    public AccountHolder (BankAccount account){
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i <4 ; i++) {
            System.out.println("Choose operation: \n 1 - Balance on the screen \n 2 - Deposit money \n 3 - Withdraw money");
            Scanner sc = new Scanner(System.in);
            int answrSc = sc.nextInt();
            if (answrSc == 1){
                procBalance();
            }else if (answrSc ==2){
                System.out.println("How much you want to deposit?" );
                Scanner scanner = new Scanner(System.in);
                int amount = scanner.nextInt();
                procDeposit(amount);
            }else if(answrSc == 3){
                System.out.println("How much you want to withdraw?");
                Scanner scanner = new Scanner(System.in);
                int amount = scanner.nextInt();
                procWithdraw(amount);
            }

        }


    }

    private synchronized void procWithdraw(int amount){
        if (account.getBalance() >= amount){
            System.out.println(Thread.currentThread().getName()+ " is going to withdraw "+ amount);
            try {
                Thread.sleep(3000);
            }catch (InterruptedException ex){
            }
            account.withdrawCash(amount);
            System.out.println(Thread.currentThread().getName()	+ " completes the withdrawal of $"+ amount);
        }else {
            System.out.println("Not enough in account for "	+ Thread.currentThread().getName() + " to withdraw "
                    + account.getBalance());
        }
    }

    private synchronized void procBalance(){
        try {
            Thread.sleep(1000);
        }catch (InterruptedException ex){
    }account.getBalance();
        System.out.println(Thread.currentThread().getName()	+ " ....loading.... " + account.getBalance() + "$ in your account");
    }

    private synchronized void procDeposit(int amount){
        try {
            Thread.sleep(1000);
        }catch (InterruptedException ex){
        }account.addCash(amount);
        System.out.println(Thread.currentThread().getName()	+" completes the deposit " + amount + "$ put into a bank account.");
   }

}
