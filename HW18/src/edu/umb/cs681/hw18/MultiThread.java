package edu.umb.cs681.hw18;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class MultiThread implements Runnable {
	
    public void run() {
        System.out.println(ConcurrentSingleton.getInstance());
    }
    
    public static void main(String[] args){
    	MultiThread objMultiThread = new MultiThread();
        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.execute(objMultiThread);
        executor.shutdown();
    }
}
