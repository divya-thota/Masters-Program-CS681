package edu.umb.cs681.hw13;

public class MultiThread implements Runnable{

	 public void run() {
	    	
	    }

	    public static void main(String[] args) {
	    	
	    	ThreadSafeBankAccount2 account = new ThreadSafeBankAccount2();
	        WithdrawRunnable withdraw = new WithdrawRunnable(account);
	        DepositRunnable deposit = new DepositRunnable(account);

	        Thread t1 = new Thread(deposit);
	        Thread t2 = new Thread(deposit);
	        Thread t3 = new Thread(deposit);
	        Thread t4 = new Thread(deposit);
	        Thread t5 = new Thread(deposit);
	        Thread t6 = new Thread(deposit);
	        Thread t7 = new Thread(deposit);
	        
	        Thread t8 = new Thread(withdraw);
	        Thread t9 = new Thread(withdraw);
	        Thread t10 = new Thread(withdraw);
	        Thread t11 = new Thread(withdraw);
	        Thread t12 = new Thread(withdraw);

	        t1.start();
	        t2.start();
	        t3.start();
	        t4.start();
	        t5.start();
	        t6.start();
	        t7.start();
	        t8.start();
	        t9.start();
	        t10.start();
	        t11.start();
	        t12.start();

	        deposit.setDone();
	        withdraw.setDone();

	        t1.interrupt();
	        t2.interrupt();
	        t3.interrupt();
	        t4.interrupt();
	        t5.interrupt();
	        t6.interrupt();
	        t7.interrupt();
	        t8.interrupt();
	        t9.interrupt();
	        t10.interrupt();
	        t11.interrupt();
	        t12.interrupt();

	        try {
	            t1.join();
	            t2.join();
	            t3.join();
	            t4.join();
	            t5.join();
	            t6.join();
	            t7.join();
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }


	    }
}
