package edu.umb.cs681.hw12;

import java.time.LocalDateTime;

public class ApfsLink extends ApfsElement {
	
	private ApfsElement target;

	public ApfsLink(ApfsDirectory parent, String name, ApfsElement target) {
		super(parent, name, 0, LocalDateTime.now());
		this.target = target;
	}

	@Override
	public boolean isDirectory() {
		return false;
	}

	@Override
	public boolean isFile() {
		return false;
	}

	@Override
	public boolean isLink() {
		return true;
	}

	public ApfsElement getTarget() {
		lock.lock();
		try {
			return this.target;
		} finally {
			lock.unlock();
		}
	}

	public void setTarget(ApfsElement target) {
		lock.lock();
		try {
			this.target = target;
		} finally {
			lock.unlock();
		}
	}
	
	public int getTargetSize() {
		lock.lock();
		try {
			return target.getSize();
		} finally {
			lock.unlock();
		}
	}
	
	public boolean targetisDirectory() {
		lock.lock();
		try {
			return target.isDirectory();
		} finally {
			lock.unlock();
		}
	}

	public boolean targetisFile() {
		lock.lock();
		try {
			return target.isFile();
		} finally {
			lock.unlock();
		}
	}

	public boolean targetisLink() {
		lock.lock();
		try {
			return target.isLink();
		} finally {
			lock.unlock();
		}
	}
}