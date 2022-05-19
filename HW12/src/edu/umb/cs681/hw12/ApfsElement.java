package edu.umb.cs681.hw12;

import java.time.LocalDateTime;
import java.util.LinkedList;

public abstract class ApfsElement extends FSElement {
	
	private LocalDateTime creationTime;
	private LocalDateTime lastModified;
	private LinkedList<ApfsElement> ApfsChildren = new LinkedList<ApfsElement>();

	protected ApfsDirectory parent;

	public ApfsElement(ApfsDirectory parent, String name, int size, LocalDateTime creationTime) {
		super(parent, name, size);
		this.parent = parent;
		this.creationTime = creationTime;
	}
	
	public LocalDateTime getCreationTime() {
		return this.creationTime;
	}

	public LocalDateTime getLastModified() {
		lock.lock();
		try {
			return this.lastModified;
		} finally {
			lock.unlock();
		}

	}

	public void setLastModified(LocalDateTime time) {
		lock.lock();
		try {
			this.lastModified = time;
		} finally {
			lock.unlock();
		}
	}

	public LinkedList<ApfsElement> getChildren() {
		return this.ApfsChildren;
	}
	
	public void appendChild(FSElement child) {
		this.ApfsChildren.add((ApfsElement) child);
	}

	public ApfsDirectory getParent() {
		lock.lock();
		try {
			return this.parent;
		} finally {
			lock.unlock();
		}
	}

	public void setParent(ApfsDirectory parent) {
		lock.lock();
		try {
			this.parent = parent;
		} finally {
			lock.unlock();
		}
	}

	public int getSize() {
		lock.lock();
		try {
			return this.size;
		} finally {
			lock.unlock();
		}
	}

	public String getName() {
		lock.lock();
		try {
			return this.name;
		} finally {
			lock.unlock();
		}
	}
	
	public abstract boolean isLink();
}
