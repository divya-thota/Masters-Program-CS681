package edu.umb.cs681.hw10;

public class MultiThread implements Runnable {

    public void run() {
    	
    	Aircraft objAircraft = new Aircraft(new Position(42.36,-71.06,49));
        System.out.println("Aircraft's original position	\t\t:"+ objAircraft.getPosition());
        objAircraft.setPosition(objAircraft.getPosition().changeAlt(15));
        System.out.println("Aircraft's original position changed to	\t:"+ objAircraft.getPosition());
        objAircraft.setPosition(new Position(40.69, -74, 102));
        System.out.println("Aircraft's new position  is set to	\t:"+ objAircraft.getPosition());
    }

    public static void main(String[] args) {
    	
    	Thread T1 = new Thread(new MultiThread());
		Thread T2 = new Thread(new MultiThread());
		
		T1.start();
		T2.start();
		
		try {
			T1.join();
			T2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}        
    }
}
