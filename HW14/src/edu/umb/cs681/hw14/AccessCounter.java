package edu.umb.cs681.hw14;

import java.nio.file.Path;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class AccessCounter {
	
	private ConcurrentHashMap<Path, AtomicInteger> mapHashMap = new ConcurrentHashMap<Path, AtomicInteger>();
	private static ReentrantLock staticLock = new ReentrantLock();
	private static AccessCounter instance = null;
	private AccessCounter() {};	
	
	public static AccessCounter getInstance() {
		staticLock.lock();
		try {
			if (instance == null)
				instance = new AccessCounter();
			return instance;
		}
		finally {
			staticLock.unlock();
		}
	}
	
	public void increment(Path path) {
		mapHashMap.compute(path, (Path p, AtomicInteger i) -> {
	        if(i == null) {
	            return new AtomicInteger(1);
	        } else {
	            return new AtomicInteger(i.incrementAndGet());
	        }
	    });
	}
	
	public int getCount(Path path) {
		return mapHashMap.compute(path, (Path p, AtomicInteger i) -> {
            if(i == null) {
                return new AtomicInteger(0);
            } else {
                return i;
            }
        }).get();
	}	
}
