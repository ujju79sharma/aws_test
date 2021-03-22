package com.java.demo.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "counters")
public class Counters {

	private String name;
	private int sequence;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
}
