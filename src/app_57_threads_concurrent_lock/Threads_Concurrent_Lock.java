package app_57_threads_concurrent_lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Threads_Concurrent_Lock {
    public static void main(String[] args) throws InterruptedException {
        Account account_1 = new Account(1);
        Account account_2 = new Account(2);
        // решение проблемы deadlock
        Thread thread_1 = new Thread(new AccountRunnable(account_1, account_2));
        Thread thread_2 = new Thread(new AccountRunnable(account_2, account_1));
        thread_1.start();
        thread_2.start();
        thread_1.join();
        thread_2.join();
        System.out.println(account_1);
        System.out.println(account_2);
    }
}

class Account {
    private int id;

    @Override
    public String toString() {
        return "Account{" +
                "money=" + money +
                ", id=" + id +
                '}';
    }

    private int money = 0;
    public void add() {
        money = money + 100;
    }
    private final Lock lock = new ReentrantLock();

    public Account(int id) {
        this.id = id;
    }

    public Lock getLock() {
        return lock;
    }
}

class AccountRunnable implements Runnable {
    public AccountRunnable(Account account_1, Account account_2) {
        this.account_1 = account_1;
        this.account_2 = account_2;
    }

    Account account_1;
    Account account_2;

    @Override
    public void run() {
        while(true){
            boolean success_account_1 = account_1.getLock().tryLock();
            boolean success_account_2 = account_2.getLock().tryLock();
            if(success_account_1 && success_account_2){
                System.out.println(Thread.currentThread().getName() +  ": account_1 and account_2 unlocked");
                break;
            }
            if(success_account_1){
                account_1.getLock().unlock();
                System.out.println(Thread.currentThread().getName() +  ": account_1 locked");
            }
            if(success_account_2){
                account_2.getLock().unlock();
                System.out.println(Thread.currentThread().getName() +  ": account_2 locked");
            }
        }
        for (int i = 0; i < 10; i++) {
            account_1.add();
            account_2.add();
        }
        account_1.getLock().unlock();
        account_2.getLock().unlock();
    }
}
