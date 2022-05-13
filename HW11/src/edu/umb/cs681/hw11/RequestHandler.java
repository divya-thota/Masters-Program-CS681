package edu.umb.cs681.hw11;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class RequestHandler implements Runnable {
	
	private ReentrantLock lock = new ReentrantLock();
	private boolean done = false;
	
	public void setDone() {
		lock.lock();
		try {
			done = true;
		}
		finally {
			lock.unlock();
		}
	}

	public void run() {
		
		String[] files = {"AccessCounter.class", 
						  "RequestHandler.class", 
						  "a.html", 
						  "b.html",
						  "c.html", 
						  "d.html"};
		AccessCounter objAccessCounter = AccessCounter.getInstance();
		
		while (true) {			
			lock.lock();
			try {
				if(done) {
	    			System.out.println("Threads execution complete");
	    			break;
	    		}
				
				int num = new Random().nextInt(files.length);
				Path path = FileSystems.getDefault().getPath(".", files[num]);				
				
				objAccessCounter.increment(path);
				System.out.println(files[num] + " path count: " + objAccessCounter.getCount(path));
			}
			finally {
				lock.unlock();
			}
			
			try {
				Thread.sleep(1000);
			}
			catch(InterruptedException e) {
				System.out.println("Error in:"+Thread.currentThread().getName()+e.toString());
				continue;
			}
		}
	}
	
	public static void main(String[] args) {
		
		RequestHandler R1  = new RequestHandler();
		RequestHandler R2  = new RequestHandler();
		
		Thread T1  = new Thread(R1);
		Thread T2  = new Thread(R2);
		
		T1.start();
		T2.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		R1.setDone();
		R2.setDone();
		
		T1.interrupt();
		T2.interrupt();
		
		try {
			T1.join();
			T2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}   		
	}	
}
