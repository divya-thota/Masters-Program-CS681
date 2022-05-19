package edu.umb.cs681.hw12;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class APFS extends FileSystem implements Runnable {
	
	private String ownerName;
	private LocalDateTime lastModified;
	private static APFS instance = null;

	public APFS(String ownerName) {
		this.ownerName = ownerName;
		this.lastModified = LocalDateTime.now();
	}
	
	public APFS getInstance() {
		if (instance == null) {
			instance = new APFS(ownerName);
		}
		return instance;
	}

	@Override
	protected FSElement createDefaultRoot() {
		return new ApfsDirectory(null, "root");
	}

	public ApfsDirectory getRootDir() {
		ApfsDirectory root = (ApfsDirectory) this.getRoot();
		return root;
	}
	
	public void setRootDir(ApfsDirectory root) {
		super.setRoot(root);
	}

	public String getOwnerName() {
		return this.ownerName;
	}

	public LocalDateTime getLastModified() {
		return this.lastModified;
	}
	
	public void run() {
		System.out.println("\nThread #" + Thread.currentThread().getId());
		System.out.println("Size of " + getRootDir().getName() + " dir: " + getRootDir().getTotalSize());
		LinkedList<ApfsElement> rootChildren = getRootDir().getChildren();
		for (ApfsElement child : rootChildren) {
			System.out.println("\n-->"+child.getName());
			LinkedList<ApfsElement> child1Children =child.getChildren();
			for (ApfsElement child1 : child1Children) {
				System.out.println("------>"+child1.getName());
				LinkedList<ApfsElement> child2Children =child1.getChildren();
				for (ApfsElement child2 : child2Children) {
					System.out.println("------>"+child2.getName());
				}
			}
		}
	}

	public static void main(String args[]) {
		
		APFS apfs = new APFS("APFS File System");
		
		apfs.initFileSystem("Local Disk", 10000);		
		ApfsDirectory root = apfs.getRootDir();
		
		ApfsDirectory applications = new ApfsDirectory(root, "applications");
		root.appendChild(applications);
		ApfsFile f1, f2;		
		f1 = new ApfsFile(applications, "f1", 40);
		f2 = new ApfsFile(applications, "f2", 100);
		applications.appendChild(f1);
		applications.appendChild(f2);
		
		Thread t1 = new Thread(apfs);				
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		ApfsDirectory home  = new ApfsDirectory(root, "home");
		root.appendChild((home));
		ApfsFile f3, f4;		
		f3 = new ApfsFile(home, "f3", 200);
		f4 = new ApfsFile(home, "f4", 400);
		home.appendChild(f3);
		home.appendChild(f4);
		
		Thread t2 = new Thread(apfs);				
		t2.start();
		try {
			t2.join();
		} catch (InterruptedException e1) {
		    e1.printStackTrace();
		}
		
		ApfsDirectory code  = new ApfsDirectory(home, "code");
		home.appendChild((code));
		ApfsFile f5, f6;		
		f5 = new ApfsFile(home, "f5", 300);
		f6 = new ApfsFile(home, "f6", 600);
		code.appendChild(f5);
		code.appendChild(f6);
		
		Thread t3 = new Thread(apfs);				
		t3.start();
		try {
			t3.join();
		} catch (InterruptedException e1) {
		    e1.printStackTrace();
		}
		
		ApfsLink x, y;	
		x = new ApfsLink(home, "x", applications);
		y = new ApfsLink(code, "y", f2);
		home.appendChild(x);
		code.appendChild(y);
		
		Thread t4 = new Thread(apfs);				
		t4.start();
		try {
			t4.join();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	}
}