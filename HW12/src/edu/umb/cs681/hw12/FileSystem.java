package edu.umb.cs681.hw12;

public abstract class FileSystem {
	
	protected String name;
	protected int capacity;
	protected int id;
	protected FSElement rootDir = null;

	public FSElement initFileSystem(String name, int capacity) {
		
		this.name = name;
		this.capacity = capacity;
		FSElement root = createDefaultRoot();
		
		if (root.isDirectory() && capacity >= root.getSize()) {
			setRoot(root);
			this.id = root.hashCode();
			return root;
		} else {
			return null;
		}
	}
	
	protected abstract FSElement createDefaultRoot();

	public FSElement getRoot() {
		return this.rootDir;
	}
	
	protected void setRoot(FSElement root) {
		rootDir = root;
	}
	
	public String getName() {
		return name;
	}

	public int getCapacity() {
		return capacity;
	}

	public int getId() {
		return id;
	}
}