package edu.umb.cs681.hw13;

import java.util.concurrent.atomic.AtomicBoolean;

public class DepositRunnable implements Runnable {

    private ThreadSafeBankAccount2 account = null;
    public AtomicBoolean done = new AtomicBoolean(false);

    public DepositRunnable(ThreadSafeBankAccount2 account) {
        this.account = account;
    }
    
    public void setDone() {
        done.getAndSet(true);
    }

    @Override
    public void run() {

        while (true) {
            if(done.get()) {
                System.out.println(Thread.currentThread().getName() +"\t Completed Deposit");
                break;
            }

            System.out.println(Thread.currentThread().getName() +"\t Depositing money");
            account.deposit(300);

            try {
                Thread.sleep(1000);
            }catch(InterruptedException e) {
            	e.printStackTrace();
            	continue;
            }
        }
    }
}
