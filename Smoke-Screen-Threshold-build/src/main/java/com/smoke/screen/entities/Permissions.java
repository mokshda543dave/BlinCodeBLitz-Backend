package com.smoke.screen.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Permissions {
	
	@Id
	private int id;
	private String name;
	private int status;
	
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Permissions() {
		super();
	}
	
}
