package com.smoke.screen.payloads;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PermissionsDTO {

	private int id;
	private String name;
	private int status;
	
	@JsonIgnore
	public int getId() {
		return id;
	}
	
	@JsonProperty
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

	public PermissionsDTO() {
		super();
	}
	
	
	
}
