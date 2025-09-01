package firstweektask;

import java.util.*;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public synchronized void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(Thread.currentThread().getName() + " deposited " + amount + ". New balance: " + balance);
        }
    }

    public synchronized void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew " + amount + ". New balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " attempted to withdraw " + amount + " but insufficient funds.");
        }
    }

    public double getBalance() {
        return balance;
    }
}

class BankingTask implements Runnable {
    private final BankAccount account;
    private final boolean isDeposit;
    private final double amount;

    public BankingTask(BankAccount account, boolean isDeposit, double amount) {
        this.account = account;
        this.isDeposit = isDeposit;
        this.amount = amount;
    }

    
    public void run() {
        if (isDeposit) {
            account.deposit(amount);
        } else {
            account.withdraw(amount);
        }
    }
}

public class Task2 {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);

        Thread t1 = new Thread(new BankingTask(account, true, 500), "User1");
        Thread t2 = new Thread(new BankingTask(account, false, 700), "User2");
        Thread t3 = new Thread(new BankingTask(account, true, 300), "User3");
        Thread t4 = new Thread(new BankingTask(account, false, 400), "User4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
