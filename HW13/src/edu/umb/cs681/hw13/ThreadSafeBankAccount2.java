package edu.umb.cs681.hw13;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeBankAccount2 {
    private double balance = 0;
    private final ReentrantLock lock = new ReentrantLock();
    Condition sufficientFundsCondition = lock.newCondition();
    Condition belowUpperLimitFundsCondition = lock.newCondition();
    public void withdraw(double amount){
        lock.lock();
        System.out.println(Thread.currentThread().getName() + "\t Current Balance is :" + balance);
        // waiting for the balance to exceed 0
        while (balance <= 0) {
        	try {
        		System.out.println(Thread.currentThread().getName() + "\t Balance below limit : Await Deposit");
                sufficientFundsCondition.await();
        	}
        	catch (InterruptedException e) {
        		e.printStackTrace();
        	}
        }

        balance -= amount;
        System.out.println(Thread.currentThread().getName() + "\t Balance after withdrawal : " + balance);
        belowUpperLimitFundsCondition.signalAll();
        lock.unlock();
        
    }
    public void deposit(double amount){

        lock.lock();
            System.out.println(Thread.currentThread().getName() + "\t Current Balance is : " + balance);
            // waiting for the balance to go below 300
            while (balance >= 300) {
            	try {
            		System.out.println(Thread.currentThread().getName() + "\t Balance exceeded limit : Await Withdrawal");
                    belowUpperLimitFundsCondition.await();
            	}
            	catch (InterruptedException e) {
            		e.printStackTrace();
            	}
                
            }

            balance += amount;
            System.out.println(Thread.currentThread().getName() + "\t Balance after deposit	: " + balance);
            sufficientFundsCondition.signalAll();

       lock.unlock();
        
    }


}
