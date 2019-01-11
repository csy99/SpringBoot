package com.example.entity;

/**
 * An entity class. It saves an entity object as a row record in its mapped
 * relational table.
 * 
 * @author CSY
 *
 */
public class User {
	private int id; // this is the primary key
	private String name; // user name
	private String address; // default address will be "na" in the database

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
