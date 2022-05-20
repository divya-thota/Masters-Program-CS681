package edu.umb.cs681.hw12;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class FileSystem implements Runnable {

	private FileSystem() {};
	private LinkedList<Directory> directoryroot;
    private static FileSystem instance = null;

    public static FileSystem getFileSystem() {
        if(instance==null)
            instance = new FileSystem ();
        return instance;
    }

    public LinkedList<Directory> getRootDirs() {
        return this.directoryroot;
    }

    void appendRootDir(Directory RootDirectory) {
        directoryroot = new LinkedList<Directory>();
        directoryroot.add(RootDirectory);
    }
    
    @Override
    public void run() {
        System.out.println("\nThread no. "+Thread.currentThread().getId()+" is running");
        for(Directory directory: getRootDirs()) {
        	System.out.println("Size of " + directory.getName() + " dir: " + directory.getTotalSize());
    		LinkedList<Directory> rootChildren = directory.getSubDirectories();
    		for (Directory child : rootChildren) {
    			System.out.println("directory "+child.getName()+" is added to directory "+child.getParent().getName());
    			for (File element : child.getFiles()) {
                    System.out.println("File "+element.getName()+" is added to the directory "+child.getName()+".");
                }
    			
    			for(Directory dir: child.getSubDirectories()) {
    				System.out.println("directory "+dir.getName()+" is added to directory "+dir.getParent().getName());
    				for (File element : dir.getFiles()) {
                        System.out.println("File "+element.getName()+" is added to the directory "+dir.getName()+".");
                    }
    			}
    		}
        }
        
    }

    public static void main(String[] args) {

        LocalDateTime localTime = LocalDateTime.now();
        FileSystem fs = new FileSystem();
        Directory root = new Directory(null, "root", 0, localTime);
        fs.appendRootDir(root);
        Directory applications = new Directory(root, "applications", 0, localTime);
        File f1 = new File(applications, "f1", 40, localTime);
        File f2 = new File(applications, "f2", 100, localTime);

        Thread t1 = new Thread(fs);
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e3) {
            e3.printStackTrace();
        }
        
        Directory home = new Directory(root, "home", 0, localTime);
        File f3 = new File(home, "f3", 200, localTime);
        File f4 = new File(home, "f4", 400, localTime);

        Directory code = new Directory(home, "code", 0, localTime);
        File f5 = new File(code, "f5", 300, localTime);
        File f6 = new File(code, "f6", 600, localTime);
     
        Thread t2 = new Thread(fs);
        t2.start();
        try {
            t2.join();
        } catch (InterruptedException e3) {
            e3.printStackTrace();
        }
    }

}
