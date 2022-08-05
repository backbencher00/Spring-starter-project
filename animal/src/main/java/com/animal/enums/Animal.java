package com.animal.enums;

public enum Animal {
	
	CAT("cat"), DOG("dog");
	private String value;

	private Animal(String value) {
		this.value = value;
	}
	public String getValue() {
		return value;
	}

}
