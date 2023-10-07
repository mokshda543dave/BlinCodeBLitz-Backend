package com.smoke.screen.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDTO {

	private int id;
	@NotBlank(message = "Name must not be blank.")
	@Size(min = 4, message = "Name must be atleast 4 characters.")
	private String name;
	@NotEmpty(message = "Email is mandatory.")
	@Email(message = "Enter a valid Email.")
	private String email;
	@NotEmpty(message = "Password can not be blank.")
	@Size(min = 6, message = "password must be atleast 6 characters.")
	private String password;
	@Pattern(regexp = "[^0-9]*", message = "Branch must be selected")
	private String branch;
	@NotNull
	@Min(value = 1, message="Sem should be between 1&8.")
	@Max(value = 8, message="Sem should be between 1&8.")
	private int sem;
	
//	No Args constructor
	
	public UserDTO() {
		super();
	}
	
//	Getters and Setters
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@JsonIgnore
	public String getPassword() {
		return password;
	}
	@JsonProperty
	public void setPassword(String password) {
		this.password = password;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public int getSem() {
		return sem;
	}
	public void setSem(int sem) {
		this.sem = sem;
	}
	
}
