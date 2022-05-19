package edu.umb.cs681.hw12;

import java.time.LocalDateTime;

public class ApfsFile extends ApfsElement {

	public ApfsFile(ApfsDirectory parent, String name, int size) {
		super(parent, name, size, LocalDateTime.now());
	}

	public boolean isDirectory() {
		return false;
	}

	public boolean isFile() {
		return true;
	}

	public boolean isLink() {
		return false;
	}
}