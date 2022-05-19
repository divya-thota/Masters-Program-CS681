package edu.umb.cs681.hw12;

import java.util.concurrent.locks.ReentrantLock;

public abstract class FSElement {
	protected String name;
	protected int size;
	
	protected ReentrantLock lock = new ReentrantLock();
	
	public FSElement(FSElement parent, String name, int size) {
		
		this.name = name;
		this.size = size;
		
	}
	
	
	public String getName() {
		
		lock.lock();
		try {
			return name;
		}finally {
			lock.unlock();
		}
		
	}
	
	public void setName(String name) {
		lock.lock();
		try {
			this.name=  name;
		}finally {
			lock.unlock();
		}
	}
	
	public int getSize() {
		lock.lock();
		try {
			return size;
		}finally {
			lock.unlock();
		}
	}
	
	public void setSize(int size) {
		lock.lock();
		try {
			this.size = size;
		}finally {
			lock.unlock();
		}
	}
	
	
	
	
	public abstract boolean isDirectory();
	
	public abstract boolean isFile();
}