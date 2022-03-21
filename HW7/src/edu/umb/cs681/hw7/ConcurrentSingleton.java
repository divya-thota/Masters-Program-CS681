package edu.umb.cs681.hw7;

import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentSingleton {

    private static ConcurrentSingleton objConcurrentSingleton = null;
    private static ReentrantLock objReentrantLock = new ReentrantLock();

    private  ConcurrentSingleton(){ }

    public static ConcurrentSingleton getInstance(){
    	objReentrantLock.lock();
        try {
            if (objConcurrentSingleton == null)
            	objConcurrentSingleton = new ConcurrentSingleton();
            return objConcurrentSingleton;
        } finally {
        	objReentrantLock.unlock();
        }
    }
}