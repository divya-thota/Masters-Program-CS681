package edu.umb.cs681.hw18;

import java.util.concurrent.atomic.AtomicReference;

public class ConcurrentSingleton {
	
	private ConcurrentSingleton() {};
	private static AtomicReference<ConcurrentSingleton> instance = 
			new AtomicReference<ConcurrentSingleton>(null);
	
	public static AtomicReference<ConcurrentSingleton> getInstance(){
		ConcurrentSingleton singletonInstance = new ConcurrentSingleton();
		if (instance.compareAndSet(null,singletonInstance)) {
            instance.set(singletonInstance);
        }        
        return instance;
    }

}
